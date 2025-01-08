package com.silo.backend.command.infrastructure.base;

import java.time.LocalDateTime;

public interface DomainEvent {
    
    int eventVersion();

    LocalDateTime occurredOn();
}

