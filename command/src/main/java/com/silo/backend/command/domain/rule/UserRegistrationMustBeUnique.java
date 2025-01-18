package com.silo.backend.command.domain.rule;

import com.silo.backend.command.domain.model.enums.UserRegistrationStatus;
import com.silo.backend.command.infrastructure.bus.base.BusinessRule;
import com.silo.backend.command.infrastructure.persistence.jpa.UserRegistrationRepository;

public class UserRegistrationMustBeUnique implements BusinessRule {

    private UserRegistrationRepository repository;
    private String email;

    public UserRegistrationMustBeUnique(UserRegistrationRepository usersCounter, String email) {
        this.repository = usersCounter;
        this.email = email;
    }

    @Override
    public Boolean isRuleComplied() {
        return repository.countByEmailAndStatus(email, UserRegistrationStatus.Confirmed) < 1;
    }

    @Override
    public String message() {
        return "User login must be unique";
    }
}
