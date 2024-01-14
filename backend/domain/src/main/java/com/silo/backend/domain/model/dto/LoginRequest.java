package com.silo.backend.domain.model.dto;

import org.immutables.value.Value;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Value.Immutable
@JsonSerialize(as = ImmutableLoginRequest.class)
@JsonDeserialize(as = ImmutableLoginRequest.class)
public abstract class LoginRequest {

    public abstract String userName();
    public abstract String password();
    
}
