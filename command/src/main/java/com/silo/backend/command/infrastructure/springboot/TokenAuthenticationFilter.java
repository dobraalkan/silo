package com.silo.backend.command.infrastructure.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.silo.backend.command.application.authentication.command.SessionAuthenticationCommand;
import com.silo.backend.command.application.dto.SessionDto;
import com.silo.backend.command.domain.service.TokenProvider;
import com.silo.backend.command.infrastructure.bus.CommandBus;
import com.silo.backend.command.infrastructure.config.AppProperties;
import com.silo.backend.command.infrastructure.security.UserAuthPrincipal;
import com.silo.backend.command.infrastructure.security.UserAuthToken;
import com.silo.backend.command.infrastructure.utils.CookieUtils;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor
public class TokenAuthenticationFilter extends OncePerRequestFilter {

    
    private final TokenProvider jwtTokenProvider;
    private final CommandBus commandBus;
    private final AppProperties properties;

    private static final Logger logger = LoggerFactory.getLogger(TokenAuthenticationFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            String jwt = getJwtTokenFromRequest(request);

            if (StringUtils.hasText(jwt) && jwtTokenProvider.validateToken(jwt)) {
                SessionDto sessionDto = commandBus.send(new SessionAuthenticationCommand(jwt));

                jwt = sessionDto.getAccessToken();

                if (!sessionDto.getAccessToken().equals(jwt)) {
                    CookieUtils.updateCookie(
                            request,
                            response,
                            properties.getAuth().getSessionAuthTokenName(),
                            CookieUtils.serialize(sessionDto.getAccessToken()),
                            (int) TimeUnit.MILLISECONDS.toSeconds(properties.getAuth().getTokenExpirationMsec()));
                }

                setAuthentication(sessionDto);
            }
        } catch (Exception ex) {
            logger.error("Could not set user authentication in security context", ex);
            SecurityContextHolder.getContext().setAuthentication(null);
        }

        filterChain.doFilter(request, response);
    }

    private void setAuthentication(SessionDto sessionDetails) {
        UserAuthToken currentAuthentication = null;

        try {
            currentAuthentication = (UserAuthToken) SecurityContextHolder.getContext().getAuthentication();
        } catch (Exception e) {
            currentAuthentication = null;
        }

        UserAuthToken newAuthentication = null;

        if (currentAuthentication == null) {
            newAuthentication = new UserAuthToken(new UserAuthPrincipal(sessionDetails));
        } else {
            UserAuthPrincipal principal = (UserAuthPrincipal) currentAuthentication.getPrincipal();
            if (!principal.getSession().getAccessToken().equals(sessionDetails.getAccessToken())) {
                newAuthentication = new UserAuthToken(new UserAuthPrincipal(sessionDetails));
            }
        }

        if (newAuthentication != null) {
            SecurityContextHolder.getContext().setAuthentication(newAuthentication);
        }
    }

    private String getJwtTokenFromRequest(HttpServletRequest request) {
        return CookieUtils.getCookie(request, properties.getAuth().getSessionAuthTokenName())
                .map(cookie -> CookieUtils.deserialize(cookie, String.class))
//                .filter(cookie -> StringUtils.hasText(cookie) && cookie.startsWith("Bearer "))
//                .map(cookie -> cookie.substring(7))
                .orElse(null);
    }
}
