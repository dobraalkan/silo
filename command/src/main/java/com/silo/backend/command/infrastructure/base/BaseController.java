package com.silo.backend.command.infrastructure.base;

import org.springframework.util.StringUtils;

import com.silo.backend.command.application.dto.Response;
import com.silo.backend.command.domain.service.TokenProvider;
import com.silo.backend.command.infrastructure.base.security.Authenticate;
import com.silo.backend.command.infrastructure.bus.CommandBus;
import com.silo.backend.command.infrastructure.bus.QueryBus;
import com.silo.backend.command.infrastructure.config.AppProperties;
import com.silo.backend.command.infrastructure.domain.Request;
import com.silo.backend.command.infrastructure.domain.command.Command;
import com.silo.backend.command.infrastructure.domain.query.Query;
import com.silo.backend.command.infrastructure.utils.CookieUtils;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class BaseController {

    CommandBus commandBus;
    QueryBus queryBus;
    AppProperties properties;
    HttpServletRequest request;
    TokenProvider jwtTokenProvider;

    protected <T extends Response> T executeCommand(Command command) {
        setAuthToken(command);
        return commandBus.send(command);
    }

    protected <T extends Response> T executeQuery(Query query) {
        setAuthToken(query);
        return queryBus.send(query);
    }

    private void setAuthToken(Request request) {
        if (request instanceof Authenticate) {
            String jwt = getJwtFromRequest();
            if (StringUtils.hasText(jwt) && jwtTokenProvider.validateToken(jwt)) {
                ((Authenticate) request).setAuthToken(jwt);
            }
        }
    }

    private String getJwtFromRequest() {
        return CookieUtils.getCookie(request, properties.getAuth().getSessionAuthTokenName())
                .map(cookie -> CookieUtils.deserialize(cookie, String.class))
                // .filter(cookie -> StringUtils.hasText(cookie) && cookie.startsWith("Bearer
                // "))
                // .map(cookie -> cookie.substring(7))
                .orElse(null);
    }
}
