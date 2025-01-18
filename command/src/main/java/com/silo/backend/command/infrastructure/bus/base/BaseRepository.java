package com.silo.backend.command.infrastructure.bus.base;

import java.util.List;

public interface BaseRepository<T, ID> {
    T save (T entity);
    T findById(ID id);
    List<T> findAll();
    void saveAll(List<T> entities);
}