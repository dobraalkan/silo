package com.silo.backend.command.application.recovery.command;

import com.silo.backend.command.infrastructure.domain.command.Command;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class UpdatePasswordWithRecoveryCodeCommand implements Command {

    @NotNull
    @Getter
    String newPassword;

    @NotNull
    @Getter
    String newPasswordRepeated;

    @NotNull
    @Getter
    String recoveryCode;

}
