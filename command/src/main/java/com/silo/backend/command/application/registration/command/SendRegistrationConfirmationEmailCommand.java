package com.silo.backend.command.application.registration.command;

import com.silo.backend.command.infrastructure.domain.command.Command;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SendRegistrationConfirmationEmailCommand implements Command {
    
    String email;
    String confirmLink;
    String confirmationCode;

}
