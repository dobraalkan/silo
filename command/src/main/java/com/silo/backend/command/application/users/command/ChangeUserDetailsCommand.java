package com.silo.backend.command.application.users.command;

import java.util.UUID;

import com.silo.backend.command.infrastructure.bus.base.security.AbstractAuthenticateCommand;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ChangeUserDetailsCommand extends AbstractAuthenticateCommand {

    private UUID userId;
    private String firstName;
    private String lastName;

    public ChangeUserDetailsCommand(UUID userId, String firstName, String lastName) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

}
