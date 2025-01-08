package com.silo.backend.command.domain.rule;

import com.silo.backend.command.domain.model.entity.user.UserRegistration;
import com.silo.backend.command.infrastructure.base.BusinessRule;

public class PasswordRecoveryCodeShouldBeExpiredOrNull implements BusinessRule {

    private UserRegistration userRegistration;

    public PasswordRecoveryCodeShouldBeExpiredOrNull(UserRegistration aUserRegistration) {
        this.userRegistration = aUserRegistration;
    }

    @Override
    public Boolean isRuleComplied() {
        return userRegistration.isRecoveryCodeExpired() || userRegistration.getRecoveryCode() == null;
    }

    @Override
    public String message() {
        return "User recovery code is not expired yet. You can't get new one after the current code expire.";
    }
}

