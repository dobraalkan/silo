package com.silo.backend.command.infrastructure.event;

import com.silo.backend.command.infrastructure.bus.base.DomainEvent;
import com.silo.backend.command.infrastructure.serializer.AbstractSerializer;

public class EventSerializer extends AbstractSerializer {

    private static EventSerializer eventSerializer;

    public static synchronized EventSerializer instance() {
        if (EventSerializer.eventSerializer == null) {
            EventSerializer.eventSerializer = new EventSerializer();
        }

        return EventSerializer.eventSerializer;
    }

    public EventSerializer(boolean isCompact) {
        this(false, isCompact);
    }

    public EventSerializer(boolean isPretty, boolean isCompact) {
        super(isPretty, isCompact);
    }

    public String serialize(DomainEvent aDomainEvent) {
        String serialization = this.gson().toJson(aDomainEvent);

        return serialization;
    }

    public <T extends DomainEvent> T deserialize(String aSerialization, final Class<T> aType) {
        T domainEvent = this.gson().fromJson(aSerialization, aType);

        return domainEvent;
    }

    private EventSerializer() {
        this(false, false);
    }
}
