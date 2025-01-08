package com.silo.backend.command.infrastructure.bus;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.silo.backend.command.application.dto.Response;
import com.silo.backend.command.infrastructure.domain.query.Query;
import com.silo.backend.command.infrastructure.service.query.QueryHandler;

@Component
public class QueryBus {

    private final Map<Class<?>, QueryHandler<?, ?>> handlers = new HashMap<>();

    public <Q extends Query, R extends Response> void registerHandler(Class<Q> queryType, QueryHandler<Q, R> handler) {
        handlers.put(queryType, handler);
    }

    public <Q extends Query, R extends Response> R send(Q query) {
        QueryHandler<Q, R > handler = (QueryHandler<Q, R>) handlers.get(query.getClass());
        if (handler == null) {
            throw new IllegalArgumentException("No query handler found for " + query.getClass().getName());
        }
        return handler.handle(query);
    }
}
