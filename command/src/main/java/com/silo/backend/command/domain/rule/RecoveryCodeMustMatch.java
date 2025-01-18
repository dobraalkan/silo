package com.silo.backend.command.domain.rule;

import com.silo.backend.command.infrastructure.bus.base.BusinessRule;

public class RecoveryCodeMustMatch implements BusinessRule {

    private String providedCode;
    private String storedCode;

    public RecoveryCodeMustMatch(String aStoredCode, String aProvidedCode) {
        this.storedCode = aStoredCode;
        this.providedCode = aProvidedCode;
    }

    @Override
    public Boolean isRuleComplied() {
        return providedCode.equals(storedCode);
    }

    @Override
    public String message() {
        return "Passwords dont match.";
    }
}
