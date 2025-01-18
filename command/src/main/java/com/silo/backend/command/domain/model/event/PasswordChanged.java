package com.silo.backend.command.domain.model.event;

import com.silo.backend.command.infrastructure.bus.base.BaseDomainEvent;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class PasswordChanged extends BaseDomainEvent  {

    private long userRegistrationId;
    private String password; //encrypted

}
