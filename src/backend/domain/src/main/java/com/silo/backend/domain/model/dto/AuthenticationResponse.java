package com.silo.backend.domain.model.dto;

import lombok.Data;

@Data
public class AuthenticationResponse {
    private UserResponse user;
    private String token;
}
