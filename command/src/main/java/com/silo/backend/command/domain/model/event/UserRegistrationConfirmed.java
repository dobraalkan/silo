package com.silo.backend.command.domain.model.event;

import java.util.UUID;

import com.silo.backend.command.domain.model.enums.UserRegistrationStatus;
import com.silo.backend.command.infrastructure.base.BaseDomainEvent;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserRegistrationConfirmed extends BaseDomainEvent  {
    private long userRegistrationId;
    private UserRegistrationStatus status;
    private UUID userId;

    public UserRegistrationConfirmed(long userRegistrationId, UserRegistrationStatus status, UUID userId) {
        this.userRegistrationId = userRegistrationId;
        this.status = status;
        this.userId = userId;
    }
}
