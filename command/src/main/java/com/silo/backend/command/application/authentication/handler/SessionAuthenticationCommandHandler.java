package com.silo.backend.command.application.authentication.handler;

import org.springframework.stereotype.Component;

import com.silo.backend.command.application.authentication.command.SessionAuthenticationCommand;
import com.silo.backend.command.application.dto.SessionDto;
import com.silo.backend.command.application.mapper.SessionMapper;
import com.silo.backend.command.domain.model.entity.Session;
import com.silo.backend.command.domain.service.SessionAuthenticationService;
import com.silo.backend.command.infrastructure.service.command.CommandHandler;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class SessionAuthenticationCommandHandler implements CommandHandler<SessionAuthenticationCommand, SessionDto> {

    private final SessionAuthenticationService sessionAuthenticationService;

    @Override
    public SessionDto handle(SessionAuthenticationCommand command) {
        Session session = sessionAuthenticationService.authenticate(command.getAuthToken());
        
        return SessionMapper.INSTANCE.toDto(session);
    }
}
