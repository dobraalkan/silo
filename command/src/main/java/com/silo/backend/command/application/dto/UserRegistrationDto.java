package com.silo.backend.command.application.dto;

import java.time.LocalDateTime;

import com.silo.backend.command.domain.model.enums.UserRegistrationStatus;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserRegistrationDto implements Response {

    private String email;
    private String firstName;
    private String lastName;
    private LocalDateTime registerDate;
    private UserRegistrationStatus status;

}
