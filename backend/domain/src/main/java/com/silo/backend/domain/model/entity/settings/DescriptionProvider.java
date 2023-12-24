package com.silo.backend.domain.model.entity.settings;

import org.immutables.value.Value;

import jakarta.annotation.Nullable;

/**
 * Nullable description
 */
public interface DescriptionProvider {

    @Value.Auxiliary
    @Nullable
    String description();
}