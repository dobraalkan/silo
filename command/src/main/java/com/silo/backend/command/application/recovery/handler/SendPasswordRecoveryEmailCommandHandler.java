package com.silo.backend.command.application.recovery.handler;

import org.springframework.stereotype.Component;

import com.silo.backend.command.application.dto.Voidy;
import com.silo.backend.command.application.recovery.command.SendPasswordRecoveryEmailCommand;
//import com.silo.backend.command.domain.service.EmailingService;
import com.silo.backend.command.infrastructure.service.command.CommandHandler;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class SendPasswordRecoveryEmailCommandHandler implements CommandHandler<SendPasswordRecoveryEmailCommand, Voidy> {

    //private final EmailingService emailingService;

    @Override
    public Voidy handle(SendPasswordRecoveryEmailCommand command) {
        // todo maybe validate if exist
       /*  this.emailingService.send(new EmailMessage(
                command.getEmail(), "", " Recovery code",
                "To reset your password, visit the following link: " + command.getRecoveryLink()
                        + command.getRecoveryCode())); */

        return new Voidy();
    }
}
