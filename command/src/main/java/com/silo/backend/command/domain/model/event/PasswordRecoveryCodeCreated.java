package com.silo.backend.command.domain.model.event;

import java.time.LocalDateTime;

import com.silo.backend.command.infrastructure.base.BaseDomainEvent;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PasswordRecoveryCodeCreated extends BaseDomainEvent  {
    long userRegistrationId;
    private String email;
    private String recoveryCode;
    private LocalDateTime recoveryCodeExpirationDate;

    public PasswordRecoveryCodeCreated(long userRegistrationId, String email, String recoveryCode, LocalDateTime recoveryCodeExpirationDate) {
        this.userRegistrationId = userRegistrationId;
        this.email = email;
        this.recoveryCode = recoveryCode;
        this.recoveryCodeExpirationDate = recoveryCodeExpirationDate;
    }
}
