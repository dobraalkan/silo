package com.silo.backend.command.infrastructure.bus.base.security;

import java.util.List;

public interface Authorize extends Authenticate {

    default List<String> getAuthorities() {
        return List.of("USER");
    }

}
