package com.silo.backend.command.domain.rule;

import com.silo.backend.command.domain.model.enums.UserRegistrationStatus;
import com.silo.backend.command.infrastructure.base.BusinessRule;

public class UserRegistrationCannotBeConfirmedMoreThanOnce implements BusinessRule {

    UserRegistrationStatus status;

    public UserRegistrationCannotBeConfirmedMoreThanOnce(UserRegistrationStatus aStatus) {
        this.status = aStatus;
    }

    @Override
    public Boolean isRuleComplied() {
        return !this.status.equals(UserRegistrationStatus.Confirmed);
    }

    @Override
    public String message() {
        return "User Registration cannot be confirmed more than once";
    }
}
