package com.silo.backend.command.domain.rule;

import java.time.LocalDateTime;

import com.silo.backend.command.infrastructure.bus.base.BusinessRule;

public class UserRegistrationCannotBeConfirmedAfterExpiration implements BusinessRule {

    public static final int CONFIRMATION_LINK_DURATION = 8;

    LocalDateTime registerDate;

    public UserRegistrationCannotBeConfirmedAfterExpiration(LocalDateTime aRegisterDate) {
        this.registerDate = aRegisterDate;
    }

    @Override
    public Boolean isRuleComplied() {
        return LocalDateTime.now().isBefore(this.registerDate.plusDays(CONFIRMATION_LINK_DURATION));
    }

    @Override
    public String message() {
        return null;
    }
}
