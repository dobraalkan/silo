package com.silo.backend.domain.model.entity.settings;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

import java.util.Optional;

@Value.Immutable
@JsonSerialize(as = ImmutableSetting.class)
@JsonDeserialize(as = ImmutableSetting.class)
public abstract class Setting implements NameProvider, DescriptionProvider {

    public abstract Optional<String> value();

    @Value.Default
    public boolean restricted() {
        return false;
    }

}
