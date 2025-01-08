package com.silo.backend.command.application.recovery.handler;

import org.springframework.stereotype.Component;

import com.silo.backend.command.application.dto.UserRegistrationDto;
import com.silo.backend.command.application.mapper.UserRegistrationMapper;
import com.silo.backend.command.application.recovery.query.GetUserRegistrationWithRecoveryCodeQuery;
import com.silo.backend.command.domain.model.entity.user.UserRegistration;
import com.silo.backend.command.infrastructure.persistence.jpa.UserRegistrationRepository;
import com.silo.backend.command.infrastructure.service.EncryptionService;
import com.silo.backend.command.infrastructure.service.query.QueryHandler;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class GetUserRegistrationWithRecoveryCodeQueryHandler implements QueryHandler<GetUserRegistrationWithRecoveryCodeQuery, UserRegistrationDto> {

    private final UserRegistrationRepository userRegistrationRepository;
    private final EncryptionService encryptionService;

    @Override
    public UserRegistrationDto handle(GetUserRegistrationWithRecoveryCodeQuery query) {
        UserRegistration userRegistration = userRegistrationRepository
                .findByRecoveryCode(encryptionService.encryptedValue(query.getRecoveryCode()));

        if (userRegistration == null) {
            throw new IllegalStateException(
                    String.format("User with recovery code %s doesn't exists.", query.getRecoveryCode()));
        }
                
        return UserRegistrationMapper.INSTANCE.toDto(userRegistration);
    }
}
