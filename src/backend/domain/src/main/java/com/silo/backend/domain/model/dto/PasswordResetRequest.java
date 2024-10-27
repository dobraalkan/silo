package com.silo.backend.domain.model.dto;

import com.silo.backend.infrastructure.ErrorMessage;

import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PasswordResetRequest {

    private String email;

    @Size(min = 6, max = 16, message = ErrorMessage.PASSWORD_CHARACTER_LENGTH)
    private String password;

    @Size(min = 6, max = 16, message = ErrorMessage.PASSWORD2_CHARACTER_LENGTH)
    private String password2;
}
