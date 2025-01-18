package com.silo.backend.command.domain.model.event;

import com.silo.backend.command.infrastructure.bus.base.BaseDomainEvent;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PasswordRecovered extends BaseDomainEvent  {
    private long userRegistrationId;
    private String password; //encrypted
    private String recoveryCode; //encrypted

    public PasswordRecovered(long userRegistrationId, String password, String recoveryCode) {
        this.userRegistrationId = userRegistrationId;
        this.password = password;
        this.recoveryCode = recoveryCode;
    }
}
