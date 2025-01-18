package com.silo.backend.command.domain.rule;

import com.silo.backend.command.domain.model.entity.Session;
import com.silo.backend.command.infrastructure.bus.base.BusinessRule;

public class SessionCannotBeExpiredWhenRefreshTokenIsMissing implements BusinessRule {

    Session session;

    public SessionCannotBeExpiredWhenRefreshTokenIsMissing(Session session) {
        this.session = session;
    }

    @Override
    public Boolean isRuleComplied() {
        return (!session.isExpired()) || (session.isExpired() && session.getRefreshToken() != null);
    }

    @Override
    public String message() {
        return String.format("Session token is expired and refresh token is missing.");
    }
}
