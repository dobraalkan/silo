package com.silo.backend.command.application.authentication.handler;

import org.springframework.stereotype.Component;

import com.silo.backend.command.application.authentication.command.SocialLoginCommand;
import com.silo.backend.command.application.mapper.SessionMapper;
import com.silo.backend.command.application.users.dto.BaseUserDto;
import com.silo.backend.command.domain.model.entity.Session;
import com.silo.backend.command.domain.model.entity.user.User;
import com.silo.backend.command.domain.service.auth.OAuth2Service;
import com.silo.backend.command.infrastructure.service.command.CommandHandler;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class SocialLoginCommandHandler extends BaseLoginCommandHandler implements CommandHandler<SocialLoginCommand, BaseUserDto> {

    private final OAuth2Service oAuth2Service;

/*     public SocialLoginCommandHandler(OAuth2Service oAuth2Service, TokenProvider tokenProvider,
            SessionRepository sessionRepository) {
        super(sessionRepository, tokenProvider);
        this.oAuth2Service = oAuth2Service;
        this.tokenProvider = tokenProvider;
    } */

    @Override
    public BaseUserDto handle(SocialLoginCommand command) {
        User user = oAuth2Service.registerAuthenticate(command.getAccessCode());

        Session session = new Session(
                user, tokenProvider,
                command.getRememberMe(),
                command.getUserAgent(), command.getIpAddress());
        sessionRepository.save(session);

        tokenProvider.addAccessTokenToCookie(session.getAccessToken());

        return SessionMapper.INSTANCE.toDto(session);
    }
}
