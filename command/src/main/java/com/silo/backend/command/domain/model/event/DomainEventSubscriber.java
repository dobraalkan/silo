package com.silo.backend.command.domain.model.event;

public interface DomainEventSubscriber<T> {

    void handleEvent(final T aDomainEvent);

    Class<T> subscribedToEventType();
}