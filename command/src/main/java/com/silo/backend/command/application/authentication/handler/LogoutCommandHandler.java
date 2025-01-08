package com.silo.backend.command.application.authentication.handler;

import org.springframework.stereotype.Component;

import com.silo.backend.command.application.authentication.command.LogoutCommand;
import com.silo.backend.command.application.dto.Voidy;
import com.silo.backend.command.domain.service.SessionAuthenticationService;
import com.silo.backend.command.infrastructure.service.command.CommandHandler;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class LogoutCommandHandler implements CommandHandler<LogoutCommand, Voidy> {

    private final SessionAuthenticationService sessionAuthenticationService;

    @Override
    public Voidy handle(LogoutCommand command) {
        sessionAuthenticationService.logout(command.getAuthToken());

        return new Voidy();
    }
}
