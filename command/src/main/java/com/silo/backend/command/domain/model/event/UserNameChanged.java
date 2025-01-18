package com.silo.backend.command.domain.model.event;

import com.silo.backend.command.infrastructure.bus.base.BaseDomainEvent;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserNameChanged extends BaseDomainEvent  {
    
    String email;
    String firstName;
    String lastName;

    public UserNameChanged(String email, String firstName, String lastName) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
