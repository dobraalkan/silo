package com.silo.backend.command.application.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.silo.backend.command.application.users.dto.BaseUserDto;
import com.silo.backend.command.domain.model.entity.user.User;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    BaseUserDto toDto(User entity);
    
    User toEntity(BaseUserDto dto);

} 