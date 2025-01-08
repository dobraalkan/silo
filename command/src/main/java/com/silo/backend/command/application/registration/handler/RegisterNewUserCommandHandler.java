package com.silo.backend.command.application.registration.handler;

import org.springframework.stereotype.Component;

import com.silo.backend.command.application.dto.UserRegistrationDto;
import com.silo.backend.command.application.mapper.UserRegistrationMapper;
import com.silo.backend.command.application.registration.command.RegisterNewUserCommand;
import com.silo.backend.command.domain.model.entity.user.UserRegistration;

import com.silo.backend.command.infrastructure.persistence.jpa.UserRegistrationRepository;
import com.silo.backend.command.infrastructure.service.command.CommandHandler;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class RegisterNewUserCommandHandler implements CommandHandler<RegisterNewUserCommand, UserRegistrationDto> {

    private final UserRegistrationRepository userRegistrationRepository;

    @Override
    public UserRegistrationDto handle(RegisterNewUserCommand command) {
        UserRegistration userRegistration = new UserRegistration(command.getPassword(),
                command.getEmail(),
                command.getFirstName(),
                command.getLastName());
        UserRegistration registeredUser = userRegistrationRepository.save(userRegistration);
        
        return UserRegistrationMapper.INSTANCE.toDto(registeredUser);
        // todo send email
    }
}
