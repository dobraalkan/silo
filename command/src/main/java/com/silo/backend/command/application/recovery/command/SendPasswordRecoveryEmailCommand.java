package com.silo.backend.command.application.recovery.command;

import java.time.LocalDateTime;

import com.silo.backend.command.infrastructure.domain.command.Command;

public class SendPasswordRecoveryEmailCommand implements Command {

    String email;
    String recoveryCode;
    String recoveryLink;
    LocalDateTime recoveryCodeExpirationDate;

}
