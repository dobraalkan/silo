package com.silo.backend.command.application.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.silo.backend.command.application.dto.SessionDto;
import com.silo.backend.command.domain.model.entity.Session;

@Mapper
public interface SessionMapper {

    SessionMapper INSTANCE = Mappers.getMapper(SessionMapper.class);

    SessionDto toDto(Session entity);
    
    Session toEntity(SessionDto dto);
} 