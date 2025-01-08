package com.silo.backend.command.domain.service;

import java.util.List;
import java.util.Optional;

public interface CrudService<E, K> {
    public List<E> getAll();

    public Optional<E> get(K id);

    public void create(E entity);

    public void update(E entity);

    public void delete(K id);
}
