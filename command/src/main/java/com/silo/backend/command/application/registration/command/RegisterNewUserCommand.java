package com.silo.backend.command.application.registration.command;

import com.silo.backend.command.infrastructure.domain.command.Command;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class RegisterNewUserCommand implements Command {

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String email;

    @NotNull
    private String password;
}
