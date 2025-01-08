package com.silo.backend.command.infrastructure.base.security;

public interface Authenticate {

    String authToken();

    void setAuthToken(String authToken);

}
