package com.silo.backend.command.domain.model.entity.user;

import java.time.LocalDateTime;
import java.util.UUID;

import com.silo.backend.command.domain.model.enums.UserRegistrationStatus;
import com.silo.backend.command.infrastructure.persistence.jpa.UserRepository;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class UserRegistration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private String confirmationCode;
    private LocalDateTime registerDate;
    @Enumerated(EnumType.STRING)
    private UserRegistrationStatus status;
    private String recoveryCode;
    private LocalDateTime recoveryCodeExpirationDate;

    private UUID userId;

    public UserRegistration(String password, String email, String firstName, String lastName) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.confirmationCode = UUID.randomUUID().toString();
        this.registerDate = LocalDateTime.now();
        this.status = UserRegistrationStatus.WaitingForConfirmation;

/*      this.assertPasswordsNotSame(aCurrentPassword, this.asEncryptedValue(aChangedPassword));
        this.setPassword(this.asEncryptedValue(aChangedPassword)); */
    }

/*     public User createUser(UserRepository userRespository) {
        this.setStatus(UserRegistrationStatus.Confirmed);

        UUID userId = userRespository.nextIdentity();
        this.setUserId(userId);

        return new User(userId, getFirstName(), getLastName(), getEmail(), User.AuthProvider.EMAIL);
    } */

    public boolean isRecoveryCodeUnexpired() {
        return recoveryCodeExpirationDate != null && recoveryCodeExpirationDate.isAfter(LocalDateTime.now());
    }

    public boolean isRecoveryCodeExpired() {
        return recoveryCodeExpirationDate != null && recoveryCodeExpirationDate.isBefore(LocalDateTime.now());
    }
/* 
    public void changePassword(String anOldPassword, String aNewPassword, String aNewPasswordRepeated) {
        this.protectPassword(this.getPassword(), aNewPassword);
    }

    public void changePasswordWithRecoveryCode(String aRecoveryCode, String aNewPassword, String aNewPasswordRepeated) {
        this.protectPassword(this.getPassword(), aNewPassword);
        this.setRecoveryCodeExpirationDate(LocalDateTime.now());
    }

    protected void protectPassword(String aCurrentPassword, String aChangedPassword) {
        this.assertPasswordsNotSame(aCurrentPassword, this.asEncryptedValue(aChangedPassword));
        this.setPassword(this.asEncryptedValue(aChangedPassword));
    } */

}
