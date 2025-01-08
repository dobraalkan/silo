package com.silo.backend.command.application.recovery.handler;

import org.springframework.stereotype.Service;

import com.silo.backend.command.application.dto.Voidy;
import com.silo.backend.command.application.recovery.command.UpdatePasswordWithRecoveryCodeCommand;
import com.silo.backend.command.domain.service.EmailAuthenticationService;
import com.silo.backend.command.infrastructure.service.command.CommandHandler;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UpdatePasswordWithRecoveryCodeCommandHandler implements CommandHandler<UpdatePasswordWithRecoveryCodeCommand, Voidy> {

    private final EmailAuthenticationService emailAuthenticationService;

    @Override
    public Voidy handle(UpdatePasswordWithRecoveryCodeCommand command) {
        emailAuthenticationService.recoverPasswordWithRecoveryCode(command.getRecoveryCode(), command.getNewPassword(), command.getNewPasswordRepeated());

        return new Voidy();
    }
}
