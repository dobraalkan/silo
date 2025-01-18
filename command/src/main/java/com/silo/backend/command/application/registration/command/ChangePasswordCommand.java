package com.silo.backend.command.application.registration.command;

import com.silo.backend.command.infrastructure.domain.command.Command;

import jakarta.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChangePasswordCommand implements Command {

    String accessToken;

    @NotNull
    private String oldPassword;

    @NotNull
    private String newPassword;

    @NotNull
    private String newPasswordRepeated;
}
