package com.silo.backend.command.application.users.handler;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.silo.backend.command.application.mapper.UserMapper;
import com.silo.backend.command.application.users.dto.BaseUserDto;
import com.silo.backend.command.application.users.query.GetUserQuery;
import com.silo.backend.command.domain.model.entity.user.User;
import com.silo.backend.command.infrastructure.persistence.jpa.UserRepository;
import com.silo.backend.command.infrastructure.service.query.QueryHandler;

@Component
public class GetUserQueryHandler implements QueryHandler<GetUserQuery, BaseUserDto> {

    private UserRepository userRepository;

    public GetUserQueryHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public BaseUserDto handle(GetUserQuery query) {
        Optional<User> user = userRepository.findById(query.getUserId());

        if (user == null) {
            throw new IllegalStateException(String.format("User with id %s doesn't exists.", query.getUserId().toString()));
        }

        return UserMapper.INSTANCE.toDto(user.get());
    }
}
