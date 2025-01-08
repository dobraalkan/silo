package com.silo.backend.command.application.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.silo.backend.command.application.dto.UserRegistrationDto;
import com.silo.backend.command.domain.model.entity.user.UserRegistration;

@Mapper
public interface UserRegistrationMapper {

    UserRegistrationMapper INSTANCE = Mappers.getMapper(UserRegistrationMapper.class);

    UserRegistrationDto toDto(UserRegistration entity);
    UserRegistration toEntity(UserRegistrationDto dto);

}
