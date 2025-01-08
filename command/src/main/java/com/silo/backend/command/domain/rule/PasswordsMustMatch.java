package com.silo.backend.command.domain.rule;

import com.silo.backend.command.infrastructure.base.BusinessRule;

public class PasswordsMustMatch implements BusinessRule {

    private String providedPassoword;
    private String storedPassword;

    public PasswordsMustMatch(String storedPassword, String providedPassoword) {
        this.storedPassword = storedPassword;
        this.providedPassoword = providedPassoword;
    }

    @Override
    public Boolean isRuleComplied() {
        return providedPassoword.equals(storedPassword);
    }

    @Override
    public String message() {
        return "Passwords dont match.";
    }
}
