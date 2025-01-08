package com.silo.backend.command.application.dto;

import java.time.LocalDateTime;

import com.silo.backend.command.application.users.dto.BaseUserDto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SessionDto extends BaseUserDto {

    private String sessionId;
    private String accessToken;
    private LocalDateTime expirationDate;
    private int expirationDateMilis;
    private String tokenType;
    private String refreshToken;
    private String userAgent;
    private String ipAddress;
    private LocalDateTime lastActivity;
    private String userId;
}
