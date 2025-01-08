package com.silo.backend.command.infrastructure.service.command;

import com.silo.backend.command.application.dto.Response;
import com.silo.backend.command.infrastructure.domain.command.Command;

public interface CommandHandler<T extends Command, R extends Response> {
    
    public R handle(T command);
}
