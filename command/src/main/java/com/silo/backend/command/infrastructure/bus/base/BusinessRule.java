package com.silo.backend.command.infrastructure.bus.base;

public interface BusinessRule {
    Boolean isRuleComplied();

    String message();
}
