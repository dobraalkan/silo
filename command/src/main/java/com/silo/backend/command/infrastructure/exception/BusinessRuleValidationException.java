package com.silo.backend.command.infrastructure.exception;

import com.silo.backend.command.infrastructure.bus.base.BusinessRule;

import lombok.Getter;

@Getter
public class BusinessRuleValidationException extends RuntimeException {

    private BusinessRule brokenRule;

    public BusinessRuleValidationException(BusinessRule brokenRule) {
        super(brokenRule.message());
        this.brokenRule = brokenRule;
    }
}