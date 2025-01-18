package com.silo.backend.command.application.authentication.command;

import com.silo.backend.command.infrastructure.bus.base.security.AbstractAuthenticateCommand;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LogoutCommand extends AbstractAuthenticateCommand {

}
