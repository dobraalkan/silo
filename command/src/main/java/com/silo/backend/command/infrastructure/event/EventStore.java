package com.silo.backend.command.infrastructure.event;

import java.util.List;

import com.silo.backend.command.domain.model.event.StoredEvent;
import com.silo.backend.command.infrastructure.bus.base.DomainEvent;

public interface EventStore {

    List<StoredEvent> allStoredEventsBetween(Long aLowStoredEventId, Long aHighStoredEventId);

    List<StoredEvent> allStoredEventsSince(Long aStoredEventId);

    StoredEvent append(DomainEvent aDomainEvent);

    void close();

    long countStoredEvents();
}