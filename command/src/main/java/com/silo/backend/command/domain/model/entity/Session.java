package com.silo.backend.command.domain.model.entity;

import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.util.UUID;

import com.silo.backend.command.domain.model.entity.user.User;
import com.silo.backend.command.domain.model.enums.TokenType;
import com.silo.backend.command.domain.service.TokenProvider;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Session {

    public static Long EXPIRATION_MSEC = 15000L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID sessionId;
    private String accessToken;
    private LocalDateTime expirationDate;

    @Enumerated(EnumType.STRING)
    private TokenType tokenType;
    private String refreshToken;
    private String userAgent;
    private String ipAddress;
    private LocalDateTime lastActivity;

    @AttributeOverride(name="id", column=@Column(name="user_id"))
    private UUID userId;

    public Session(User user, TokenProvider tokenProvider, Boolean rememberMe, String userAgent, String ipAddress)
    {
        this.ipAddress = ipAddress;
        this.userAgent = userAgent;
        this.tokenType = tokenProvider.getTokenType();
        this.userId = user.getUserId();
        this.expirationDate = LocalDateTime.now().plus(EXPIRATION_MSEC, ChronoField.MILLI_OF_DAY.getBaseUnit());
        this.accessToken = tokenProvider.createToken(user);

        if (Boolean.TRUE.equals(rememberMe)) {
            //this.refreshToken = tokenProvider.createRefreshToken(user);
        }

        //DomainEventPublisher.instance().publish(new SessionCreated(this.getSessionId(), this.getUserId()));
    }

    public boolean isExpired() {
        return !expirationDate.isAfter(LocalDateTime.now());
    }

}
