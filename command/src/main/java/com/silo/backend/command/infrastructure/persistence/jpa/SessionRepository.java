package com.silo.backend.command.infrastructure.persistence.jpa;

import org.springframework.stereotype.Repository;

import com.silo.backend.command.domain.model.entity.Session;

import java.util.List;
import java.util.UUID;

@Repository
public interface SessionRepository extends CrudRepository<Session, UUID> {

    UUID nextIdentity();

    List<Session> findByUserId(UUID userId);

    Session findByAccessToken(String accessToken);
}
