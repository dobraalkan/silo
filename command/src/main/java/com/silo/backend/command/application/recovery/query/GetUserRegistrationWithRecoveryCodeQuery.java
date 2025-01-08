package com.silo.backend.command.application.recovery.query;

import com.silo.backend.command.infrastructure.domain.query.Query;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class GetUserRegistrationWithRecoveryCodeQuery implements Query {

    @NotNull
    @Getter
    String recoveryCode;

}
