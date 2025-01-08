package com.silo.backend.command.infrastructure.base;

public interface BusinessRule {
    Boolean isRuleComplied();

    String message();
}
