package com.silo.backend.command.domain.rule;

import com.silo.backend.command.domain.model.enums.UserRegistrationStatus;
import com.silo.backend.command.infrastructure.bus.base.BusinessRule;

public class UserRegistrationMustBeConfirmed implements BusinessRule {

    private UserRegistrationStatus userRegistrationStatus;

    public UserRegistrationMustBeConfirmed(UserRegistrationStatus anUserRegistrationStatus) {
        this.userRegistrationStatus = anUserRegistrationStatus;
    }

    @Override
    public Boolean isRuleComplied() {
        return userRegistrationStatus.equals(UserRegistrationStatus.Confirmed);
    }

    @Override
    public String message() {
        return "User registration is not confirmed yet.";
    }
}
