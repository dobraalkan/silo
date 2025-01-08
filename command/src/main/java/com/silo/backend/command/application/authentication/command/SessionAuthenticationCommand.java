package com.silo.backend.command.application.authentication.command;

import com.silo.backend.command.infrastructure.base.security.AbstractAuthenticateCommand;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SessionAuthenticationCommand extends AbstractAuthenticateCommand {

    public SessionAuthenticationCommand(String authToken) {
        super(authToken);
    }
}
