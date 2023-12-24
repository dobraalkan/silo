package com.silo.backend.domain.model.dto;

import org.immutables.value.Value;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import jakarta.annotation.Nullable;

@Value.Immutable
@JsonSerialize(as = ImmutablePasswordResetRequest.class)
@JsonDeserialize(as = ImmutablePasswordResetRequest.class)
public abstract class PasswordResetRequest {

    public abstract String userName();

    @Nullable
    public abstract String currentPassword();

    public abstract String newPassword();
}
