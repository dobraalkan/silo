package com.silo.backend.command.infrastructure.service.query;

import com.silo.backend.command.application.dto.Response;
import com.silo.backend.command.infrastructure.domain.query.Query;

public interface QueryHandler<Q extends Query, R extends Response> {
    
    R handle(Q query);
}


