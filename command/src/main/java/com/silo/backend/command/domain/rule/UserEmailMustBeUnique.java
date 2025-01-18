package com.silo.backend.command.domain.rule;

import com.silo.backend.command.infrastructure.bus.base.BusinessRule;
import com.silo.backend.command.infrastructure.persistence.jpa.UserRepository;

public class UserEmailMustBeUnique implements BusinessRule {

    UserRepository userRespository;
    String email;

    public UserEmailMustBeUnique(UserRepository userRespository, String email) {
        this.userRespository = userRespository;
        this.email = email;
    }

    @Override
    public Boolean isRuleComplied() {
        return userRespository.findByEmail(this.email) == null;
    }

    @Override
    public String message() {
        return "User with this email already exists.";
    }
}
