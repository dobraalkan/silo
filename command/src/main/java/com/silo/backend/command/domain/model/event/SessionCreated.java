package com.silo.backend.command.domain.model.event;

import java.util.UUID;

import com.silo.backend.command.infrastructure.base.BaseDomainEvent;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SessionCreated extends BaseDomainEvent  {
    
    private UUID sessionId;
    private UUID userId;

    public SessionCreated(UUID sessionId, UUID userId) {
        this.sessionId = sessionId;
        this.userId = userId;
    }
}
