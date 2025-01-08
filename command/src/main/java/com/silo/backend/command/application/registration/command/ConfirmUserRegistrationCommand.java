package com.silo.backend.command.application.registration.command;

import com.silo.backend.command.infrastructure.domain.command.Command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class ConfirmUserRegistrationCommand implements Command {

    private String confirmationLink;

}
