package com.silo.backend.command.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.silo.backend.command.domain.model.entity.user.User;
import com.silo.backend.command.domain.model.enums.TokenType;
import com.silo.backend.command.infrastructure.config.AppProperties;
import com.silo.backend.command.infrastructure.utils.CookieUtils;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class TokenProvider {

    AppProperties appProperties;
    HttpServletResponse response;

    public String createToken(User user) {
        Claims claims = Jwts.claims().subject(user.getEmail()).build();

        //claims.put("role", role);

        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + appProperties.getAuth().getTokenExpirationMsec());

        return Jwts.builder()
                .claims(claims)
                .issuedAt(now)
                .expiration(expiryDate)
                .signWith(secretKey())
                .compact();
    }

    public UUID getUserIdFromToken(String authToken) {
        return UUID.fromString(parseClaims(authToken).getSubject());
    }

    public boolean validateToken(String authToken) {
        try {
            if (!StringUtils.hasText(authToken))
                return false;
            var claims = parseClaims(authToken);
            return !claims.getExpiration().before(new Date());
        } catch (SecurityException ex) {
            log.error("Invalid JWT signature");
        } catch (MalformedJwtException ex) {
            log.error("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            log.error("Expired JWT token");
            throw ex;
        } catch (UnsupportedJwtException ex) {
            log.error("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            log.error("JWT claims string is empty.");
        }

        return false;
    }

    public TokenType getTokenType() {
        return TokenType.CLIENT_SECRET_JWT;
    }
    public void addAccessTokenToCookie(String accessToken) {
        CookieUtils.addCookie(
                response,
                appProperties.getAuth().getSessionAuthTokenName(),
                CookieUtils.serialize(accessToken),
                (int) TimeUnit.MILLISECONDS.toSeconds(appProperties.getAuth().getTokenExpirationMsec()));
    }

    private Claims parseClaims(String authToken) {
        return Jwts.parser()
                .verifyWith(secretKey())
                .build()
                .parseSignedClaims(authToken)
                .getPayload();
    }

    private SecretKey secretKey() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(appProperties.getAuth().getTokenSecret()));
    }
}
