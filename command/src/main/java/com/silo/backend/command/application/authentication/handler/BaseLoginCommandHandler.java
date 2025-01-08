package com.silo.backend.command.application.authentication.handler;

import com.silo.backend.command.domain.service.TokenProvider;
import com.silo.backend.command.infrastructure.persistence.jpa.SessionRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class BaseLoginCommandHandler {
    
    protected SessionRepository sessionRepository;
    protected TokenProvider tokenProvider;
}
