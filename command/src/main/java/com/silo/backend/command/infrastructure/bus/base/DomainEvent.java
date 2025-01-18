package com.silo.backend.command.infrastructure.bus.base;

import java.time.LocalDateTime;

public interface DomainEvent {
    
    int eventVersion();

    LocalDateTime occurredOn();
}

