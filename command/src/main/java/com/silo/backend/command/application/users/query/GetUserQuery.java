package com.silo.backend.command.application.users.query;

import java.util.UUID;

import com.silo.backend.command.infrastructure.bus.base.security.AbstractAuthenticateQuery;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetUserQuery extends AbstractAuthenticateQuery {

    @NotNull
    String userId;

    public GetUserQuery(String userId) {
        this.userId = userId;
    }

    public UUID getUserId() {
        return UUID.fromString(this.userId);
    }
}
