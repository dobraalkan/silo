package com.silo.backend.command.infrastructure.bus;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.silo.backend.command.application.dto.Response;
import com.silo.backend.command.infrastructure.domain.command.Command;
import com.silo.backend.command.infrastructure.service.command.CommandHandler;

@Component
public class CommandBus {

    private final Map<Class<?>, CommandHandler<?, ?>> handlers = new HashMap<>();

    public <C extends Command, R extends Response> void registerHandler(Class<C> commandType, CommandHandler<C, R> handler) {
        handlers.put(commandType, handler);
    }

    public <C extends Command, R extends Response> R send(C command) {
        CommandHandler<C, R> handler = (CommandHandler<C, R>) handlers.get(command.getClass());
        if (handler == null) {
            throw new IllegalArgumentException("No command handler found for " + command.getClass().getName());
        }
        return handler.handle(command);
    }
}
