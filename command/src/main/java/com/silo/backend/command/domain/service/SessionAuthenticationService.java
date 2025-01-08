package com.silo.backend.command.domain.service;

import org.springframework.stereotype.Service;

import com.silo.backend.command.domain.model.entity.Session;
import com.silo.backend.command.infrastructure.base.BaseService;
import com.silo.backend.command.infrastructure.persistence.jpa.SessionRepository;
import com.silo.backend.command.infrastructure.persistence.jpa.UserRepository;

import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class SessionAuthenticationService extends BaseService {

    private final TokenProvider tokenProvider;
    private final SessionRepository sessionRepository;
    private final UserRepository userRepository;

    public Session authenticate(String anAccessToken) {
        assertArgumentNotEmpty(anAccessToken, "Session token cannot be empty.");

        Session session = sessionRepository.findByAccessToken(anAccessToken);
        if (session == null) {
            throw new IllegalStateException(String.format("Session with access code %s doesn't exist.", anAccessToken));
        }

        this.assertStateTrue(!session.isExpired() || (session.isExpired() && session.getRefreshToken() != null),"Session token is expired and refresh token is missing.");

        if (session.isExpired()) {
            return new Session(
                    sessionRepository.nextIdentity(),
                    userRepository.findById(session.getUserId()).get(),
                    tokenProvider,
                    true,
                    session.getUserAgent(),
                    session.getIpAddress());
        }

        session.setLastActivity(LocalDateTime.now());
        return session;
    }

    public Session logout(String anAccessToken) {
        assertArgumentNotEmpty(anAccessToken, "Session token cannot be empty.");

        Session session = sessionRepository.findByAccessToken(anAccessToken);
        if (session == null) {
            throw new IllegalStateException(String.format("Session with access code %s doesn't exist.", anAccessToken));
        }

        session.setExpirationDate(LocalDateTime.now());
        session.setRefreshToken(null);

        return sessionRepository.save(session);
    }
}
