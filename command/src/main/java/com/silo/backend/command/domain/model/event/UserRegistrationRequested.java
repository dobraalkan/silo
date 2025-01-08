package com.silo.backend.command.domain.model.event;

import java.time.LocalDateTime;

import com.silo.backend.command.domain.model.enums.UserRegistrationStatus;
import com.silo.backend.command.infrastructure.base.BaseDomainEvent;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserRegistrationRequested extends BaseDomainEvent  {
    
    private long userRegistrationId;
    private String email;
    private String confirmationCode;
    private String firstName;
    private String lastName;
    private LocalDateTime registerDate;
    private UserRegistrationStatus status;

    public UserRegistrationRequested(
            String email,
            String confirmationCode,
            String firstName,
            String lastName,
            LocalDateTime registerDate,
            UserRegistrationStatus status) {
        this.email = email;
        this.confirmationCode = confirmationCode;
        this.firstName = firstName;
        this.lastName = lastName;
        this.registerDate = registerDate;
        this.status = status;
    }
}
