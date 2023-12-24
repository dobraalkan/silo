package com.silo.backend.domain.model.entity.settings;

import org.immutables.value.Value;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.silo.backend.domain.model.entity.command.Command;

@Value.Immutable
@JsonSerialize(as = ImmutableUpdateSettingsCommand.class)
@JsonDeserialize(as = ImmutableUpdateSettingsCommand.class)
public abstract class UpdateSettingsCommand implements Command {

    public abstract String name();
    public abstract String value();

}
