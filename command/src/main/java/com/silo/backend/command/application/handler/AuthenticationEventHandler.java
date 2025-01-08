package com.silo.backend.command.application.handler;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.silo.backend.command.domain.model.event.DomainEventPublisher;
import com.silo.backend.command.domain.model.event.DomainEventSubscriber;
import com.silo.backend.command.domain.model.event.EventStore;
import com.silo.backend.command.infrastructure.base.DomainEvent;

@Aspect
@Component
public class AuthenticationEventHandler {

    private EventStore eventStore;

    public AuthenticationEventHandler(EventStore eventStore) {
        this.eventStore = eventStore;
    }

    @Before(value = "execution(* *(..)) && within(com.tomo.mcauthentication.application..*)")
    public void listen() {
        DomainEventPublisher
            .instance()
            .subscribe(new DomainEventSubscriber<DomainEvent>() {

                public void handleEvent(DomainEvent domainEvent) {
                    store(domainEvent);
                }

                public Class<DomainEvent> subscribedToEventType() {
                    return DomainEvent.class; // all domain events
                }
            });
    }

    /**
     * Stores domainEvent to the event store.
     * @param domainEvent the DomainEvent to store
     */
    private void store(DomainEvent domainEvent) {
        this.eventStore().append(domainEvent);
    }

    /**
     * Answers my EventStore.
     * @return EventStore
     */
    private EventStore eventStore() {
        return this.eventStore;
    }
}
