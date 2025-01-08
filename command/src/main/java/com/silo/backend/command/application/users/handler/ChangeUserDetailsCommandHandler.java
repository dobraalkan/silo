package com.silo.backend.command.application.users.handler;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.silo.backend.command.application.dto.Voidy;
import com.silo.backend.command.application.users.command.ChangeUserDetailsCommand;
import com.silo.backend.command.domain.model.entity.user.User;
import com.silo.backend.command.domain.service.TokenProvider;
import com.silo.backend.command.infrastructure.persistence.jpa.UserRepository;
import com.silo.backend.command.infrastructure.service.command.CommandHandler;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ChangeUserDetailsCommandHandler implements CommandHandler<ChangeUserDetailsCommand, Voidy> {

    private final TokenProvider tokenProvider;
    private final UserRepository userRepository;

    @Override
    public Voidy handle(ChangeUserDetailsCommand command) {
        UUID userId = tokenProvider.getUserIdFromToken(command.getAuthToken());

        if (!command.getUserId().equals(userId)) {
            throw new IllegalArgumentException(String.format("Forbidden access. User with ID %s cannot change user details for user with ID: %s", userId.toString(), command.getUserId()));
        }

        User user = userRepository.findById(command.getUserId()).orElseThrow();
        user.updateDetails(command.getFirstName(), command.getLastName());

        userRepository.save(user);

        return new Voidy();
    }
}
