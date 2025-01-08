package com.silo.backend.command.application.recovery.handler;

import org.springframework.stereotype.Service;

import com.silo.backend.command.application.dto.RecoveryPasswordDto;
import com.silo.backend.command.application.recovery.command.CreatePasswordRecoveryCodeCommand;
import com.silo.backend.command.domain.service.EmailAuthenticationService;
import com.silo.backend.command.infrastructure.service.command.CommandHandler;

@Service
public class CreatePasswordRecoveryCodeCommandHandler implements CommandHandler<CreatePasswordRecoveryCodeCommand, RecoveryPasswordDto> {

    EmailAuthenticationService emailAuthenticationService;

    public CreatePasswordRecoveryCodeCommandHandler(EmailAuthenticationService emailAuthenticationService) {
        this.emailAuthenticationService = emailAuthenticationService;
    }

    @Override
    public RecoveryPasswordDto handle(CreatePasswordRecoveryCodeCommand command) {
        return new RecoveryPasswordDto(
                emailAuthenticationService
                        .createPasswordRecoveryCode(command.getEmail())
        );

        //todo send recovery code
    }
}
