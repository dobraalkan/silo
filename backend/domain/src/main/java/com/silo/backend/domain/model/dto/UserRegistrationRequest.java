package com.silo.backend.domain.model.dto;

import org.immutables.value.Value;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Value.Immutable
@JsonSerialize(as = ImmutableUserRegistrationRequest.class)
@JsonDeserialize(as = ImmutableUserRegistrationRequest.class)
public abstract class UserRegistrationRequest {

    public abstract String userName();
    public abstract String password();
    
}
