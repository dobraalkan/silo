package com.silo.backend.command.domain.service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.silo.backend.command.domain.model.entity.user.User;
import com.silo.backend.command.domain.model.entity.user.UserRegistration;
import com.silo.backend.command.infrastructure.base.BaseService;
import com.silo.backend.command.infrastructure.persistence.jpa.UserRegistrationRepository;
import com.silo.backend.command.infrastructure.persistence.jpa.UserRepository;
import com.silo.backend.command.infrastructure.service.EncryptionService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmailAuthenticationService extends BaseService {

    private final UserRegistrationRepository userRegistrationRepository;
    private final UserRepository userRepository;
    private final EncryptionService encryptionService;

    public static Long RECOVERY_CODE_EXPIREATION_MSEC = 172800000L;

    public User authenticate(String anEmail, String aPassword) {

        this.assertArgumentNotEmpty(anEmail, "Email must be provided.");
        this.assertArgumentNotEmpty(aPassword, "Password must be provided.");

        UserRegistration userRegistration = userRegistrationRepository.findByEmail(anEmail);

        if (userRegistration == null) {
            throw new IllegalStateException(String.format("User with email %s doesn't exists.", anEmail));
        }

        this.assertArgumentEquals(userRegistration.getPassword(), encryptionService.encryptedValue(aPassword),
                "Passwords dont match.");

        return userRepository.findByEmail(anEmail);
    }

    public String createPasswordRecoveryCode(String anEmail) {
        this.assertArgumentNotEmpty(anEmail, "Email must be provided.");

        UserRegistration userRegistration = userRegistrationRepository.findByEmail(anEmail);

        if (userRegistration == null) {
            throw new IllegalStateException(String.format("User with email %s doesn't exists.", anEmail));
        }

        String recoveryCode = UUID.randomUUID().toString();
        LocalDateTime recoveryCodeExpirationDate = LocalDateTime.now().plus(RECOVERY_CODE_EXPIREATION_MSEC,
                ChronoField.MILLI_OF_DAY.getBaseUnit());
        userRegistration.setRecoveryCode(encryptionService.encryptedValue(recoveryCode));
        userRegistration.setRecoveryCodeExpirationDate(recoveryCodeExpirationDate);

        userRegistrationRepository.save(userRegistration);

        return recoveryCode;
    }

    public void recoverPasswordWithRecoveryCode(String aRecoveryCode, String aNewPassword,
            String aNewPasswordRepeated) {
        this.assertArgumentNotNull(aRecoveryCode, "Recovery code is missing.");

        UserRegistration userRegistration = userRegistrationRepository
                .findByRecoveryCode(encryptionService.encryptedValue(aRecoveryCode));

        if (userRegistration == null) {
            throw new IllegalStateException(String.format("User with recovery code %s doesn't exists.", aRecoveryCode));
        }

        this.assertArgumentNotEquals(userRegistration.getPassword(), encryptionService.encryptedValue(aNewPassword),"Repeated password must be same from password.");
        userRegistration.setPassword(encryptionService.encryptedValue(aNewPassword));
        userRegistration.setRecoveryCodeExpirationDate(LocalDateTime.now());

        userRegistrationRepository.save(userRegistration);
    }
}
