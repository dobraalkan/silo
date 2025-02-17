package com.silo.backend.command.infrastructure.bus.base;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseDomainEvent implements DomainEvent {

   private int eventVersion;
   private LocalDateTime occuredOn;

    public BaseDomainEvent() {
        this.eventVersion = 1;
        this.occuredOn = LocalDateTime.now();
    }

    @Override
    public int eventVersion() {
        return eventVersion;
    }

    @Override
    public LocalDateTime occurredOn() {
        return occuredOn;
    }
}
