package com.silo.backend.command.application.authentication.command;

import com.silo.backend.command.infrastructure.domain.command.Command;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseLoginCommand implements Command {
    
    Boolean rememberMe;
    String userAgent;
    String ipAddress;

}
