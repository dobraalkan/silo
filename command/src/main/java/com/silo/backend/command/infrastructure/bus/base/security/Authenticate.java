package com.silo.backend.command.infrastructure.bus.base.security;

public interface Authenticate {

    String authToken();

    void setAuthToken(String authToken);

}
