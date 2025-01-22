package com.silo.backend.command.application.authentication.handler;

import org.springframework.stereotype.Component;

import com.silo.backend.command.application.authentication.command.EmailLoginCommand;
import com.silo.backend.command.application.dto.SessionDto;
import com.silo.backend.command.application.mapper.SessionMapper;
import com.silo.backend.command.domain.model.entity.Session;
import com.silo.backend.command.domain.model.entity.user.User;
import com.silo.backend.command.domain.service.EmailAuthenticationService;
import com.silo.backend.command.infrastructure.service.command.CommandHandler;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class EmailLoginCommandHandler extends BaseLoginCommandHandler implements CommandHandler<EmailLoginCommand, SessionDto> {

    private final EmailAuthenticationService authenticationService;

    @Override
    public SessionDto handle(EmailLoginCommand command) {
        User user = authenticationService.authenticate(command.getEmail(), command.getPassword());
        Session session = new Session(
                user, tokenProvider,
                command.getRememberMe(),
                command.getUserAgent(), command.getIpAddress());

        sessionRepository.save(session);

        tokenProvider.addAccessTokenToCookie(session.getAccessToken());

        return SessionMapper.INSTANCE.toDto(session);
    }
}
