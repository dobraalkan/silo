package com.silo.backend.command.infrastructure.persistence.jpa;

import org.springframework.stereotype.Repository;

import com.silo.backend.command.domain.model.entity.user.UserRegistration;
import com.silo.backend.command.domain.model.enums.UserRegistrationStatus;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserRegistrationRepository extends CrudRepository <UserRegistration, Long> {

    //UUID nextIdentity();
    
    long countByEmail(String email);

    long countByEmailAndStatus(String email, UserRegistrationStatus status);

    List<UserRegistration> findAllByEmailIn(List<String> email);

    UserRegistration findByConfirmationCode(String confirmLink);

    UserRegistration findByEmail(String email);

    UserRegistration findByRecoveryCode(String recoveryCode);

    UserRegistration findByUserId(UUID userId);
}
