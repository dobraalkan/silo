package com.silo.backend.domain.model.entity.user;

import org.immutables.value.Value;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Set;


@Value.Immutable
@JsonSerialize(as = ImmutableUser.class)
@JsonDeserialize(as = ImmutableUser.class)
public abstract class User implements UserNameProvider {

    public abstract Set<String> roles();

    public boolean hasRole(String role) {
        if (role == null) { return false; }

        return roles().contains(role);
    }

}
