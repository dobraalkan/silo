package com.silo.backend.command.application.registration.handler;

import org.springframework.stereotype.Service;

import com.silo.backend.command.application.dto.Voidy;
import com.silo.backend.command.application.registration.command.ChangePasswordCommand;
import com.silo.backend.command.domain.model.entity.Session;
import com.silo.backend.command.domain.model.entity.user.UserRegistration;
import com.silo.backend.command.domain.service.SessionAuthenticationService;
import com.silo.backend.command.infrastructure.persistence.jpa.UserRegistrationRepository;
import com.silo.backend.command.infrastructure.service.EncryptionService;
import com.silo.backend.command.infrastructure.service.command.CommandHandler;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ChangePasswordCommandHandler implements CommandHandler<ChangePasswordCommand, Voidy> {

    private final SessionAuthenticationService sessionAuthenticationService;
    private final UserRegistrationRepository userRegistrationRepository;
    private final EncryptionService encryptionService;

    @Override
    public Voidy handle(ChangePasswordCommand command) {
        Session session = sessionAuthenticationService.authenticate(command.getAccessToken());

        UserRegistration userRegistration = userRegistrationRepository.findByUserId(session.getUserId());

        if (userRegistration == null) {
            throw new IllegalStateException(String.format("User with id %s doesn't exist.", session.getUserId()));
        }

        //this.assertArgumentEquals(encryptionService.encryptedValue(command.getOldPassword()),encryptionService.encryptedValue(userRegistration.getPassword()),"Old password is wrong.");
        //this.assertArgumentEquals(encryptionService.encryptedValue(command.getNewPassword()),encryptionService.encryptedValue(command.getNewPasswordRepeated()),"Old password is wrong.");
        //this.assertArgumentNotEquals(userRegistration.getPassword(), encryptionService.encryptedValue(command.getNewPassword()),"Repeated password must be same from password.");
        userRegistration.setPassword(encryptionService.encryptedValue(command.getNewPassword()));

        userRegistrationRepository.save(userRegistration);

        return new Voidy();
    }
}
