package com.silo.backend.command.infrastructure.persistence.jpa;

import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.silo.backend.command.domain.model.entity.user.User;

@Repository
public interface UserRepository extends CrudRepository<User, UUID> {

    UUID nextIdentity();
    User findByEmail(String anEmail);
}
