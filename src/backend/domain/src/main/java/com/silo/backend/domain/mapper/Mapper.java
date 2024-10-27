package com.silo.backend.domain.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class Mapper {

    private final static ModelMapper modelMapper = new ModelMapper();

    public static <T, S> S convertToEntity(T data, Class<S> type) {
        return modelMapper.map(data, type);
    }

    public static <T, S> S convertToResponse(T data, Class<S> type) {
        return modelMapper.map(data, type);
    }

    public static <T, S> List<S> convertToResponseList(List<T> lists, Class<S> type) {
        return lists.stream()
                .map(list -> convertToResponse(list, type))
                .collect(Collectors.toList());
    }
}
