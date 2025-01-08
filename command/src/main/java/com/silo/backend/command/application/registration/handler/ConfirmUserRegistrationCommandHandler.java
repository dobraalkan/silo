package com.silo.backend.command.application.registration.handler;

import org.springframework.stereotype.Component;

import com.silo.backend.command.application.registration.command.ConfirmUserRegistrationCommand;
import com.silo.backend.command.application.users.dto.BaseUserDto;
import com.silo.backend.command.domain.model.entity.user.User;
import com.silo.backend.command.domain.model.entity.user.UserRegistration;
import com.silo.backend.command.infrastructure.persistence.jpa.UserRegistrationRepository;
import com.silo.backend.command.infrastructure.persistence.jpa.UserRepository;
import com.silo.backend.command.infrastructure.service.command.CommandHandler;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ConfirmUserRegistrationCommandHandler implements CommandHandler<ConfirmUserRegistrationCommand, BaseUserDto> {

    private final UserRegistrationRepository userRegistrationRepository;
    private final UserRepository userRepository;

    @Override
    public BaseUserDto handle(ConfirmUserRegistrationCommand command) {
        UserRegistration userRegistration = userRegistrationRepository.findByConfirmationCode(command.getConfirmationLink());

        if (userRegistration == null) {
            throw new IllegalStateException(
                    String.format("UserRegistration with confirmation link %s cannot be found.", command.getConfirmationLink())
            );
        }

        User user = userRegistration.createUser(userRepository);
        userRegistration.setUserId(user.getUserId());

        userRepository.save(user);
        userRegistrationRepository.save(userRegistration);
        return null;
    }
}
