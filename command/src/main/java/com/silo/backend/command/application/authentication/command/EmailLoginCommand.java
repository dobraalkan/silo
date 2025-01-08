package com.silo.backend.command.application.authentication.command;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EmailLoginCommand extends BaseLoginCommand {

    @NotBlank
    @Email
    String email;
    
    @NotBlank
    String password;

}
