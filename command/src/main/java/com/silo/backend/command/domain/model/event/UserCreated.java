package com.silo.backend.command.domain.model.event;

import java.util.UUID;

import com.silo.backend.command.domain.model.entity.user.User;
import com.silo.backend.command.infrastructure.bus.base.BaseDomainEvent;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserCreated extends BaseDomainEvent  {
    
    UUID userId;
    String firstName;
    String lastName;
    String email;
    User.AuthProvider provider;

    public UserCreated(UUID userId, String firstName, String lastName, String email, User.AuthProvider provider) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.provider = provider;
    }
}
