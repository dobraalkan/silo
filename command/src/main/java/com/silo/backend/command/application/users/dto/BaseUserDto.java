package com.silo.backend.command.application.users.dto;

import com.silo.backend.command.application.dto.Response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BaseUserDto implements Response {

    private String userId;
    private String firstName;
    private String lastName;
}
