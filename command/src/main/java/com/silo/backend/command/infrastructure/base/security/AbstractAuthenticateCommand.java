package com.silo.backend.command.infrastructure.base.security;


import com.silo.backend.command.infrastructure.domain.command.Command;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public abstract class AbstractAuthenticateCommand implements Command, Authenticate {

    String authToken;

    public AbstractAuthenticateCommand(String authToken) {
        this.authToken = authToken;
    }

    @Override
    public String authToken() {
        return this.authToken;
    }

    @Override
    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }
}
