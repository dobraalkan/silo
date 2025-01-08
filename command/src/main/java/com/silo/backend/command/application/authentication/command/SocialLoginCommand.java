package com.silo.backend.command.application.authentication.command;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SocialLoginCommand extends BaseLoginCommand {
    
    String accessCode;

}
