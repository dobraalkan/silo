package com.silo.backend.command.application.registration.handler;

import org.springframework.stereotype.Component;

import com.silo.backend.command.application.dto.Voidy;
import com.silo.backend.command.application.registration.command.SendRegistrationConfirmationEmailCommand;
//import com.silo.backend.command.domain.service.EmailingService;
import com.silo.backend.command.infrastructure.service.command.CommandHandler;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class SendRegistrationConfirmationEmailCommandHandler
        implements CommandHandler<SendRegistrationConfirmationEmailCommand, Voidy> {

    //private final EmailingService emailingService;

    @Override
    public Voidy handle(SendRegistrationConfirmationEmailCommand command) {
        // todo maybe validate if exist
 /*        emailingService.send(new EmailMessage(
                command.getEmail(), "", "Confirm registration",
                "Click on this confirmation link " + command.getConfirmLink() + command.getConfirmationCode())); */

        return new Voidy();
    }
}
