package com.silo.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.silo.backend.domain.model.entity.Component;
import com.silo.backend.domain.repository.ComponentRepository;
import com.silo.backend.infrastructure.CrudService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
@Slf4j
public class ComponentService implements CrudService<Component, String> {
    
    private ComponentRepository componentRepository;

    @Override
    public List<Component> getAll() {
        return componentRepository.findAll();
    }

    @Override
    public Optional<Component> get(String id) {
        return componentRepository.findById(id);
    }

    @Override
    public void create(Component entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public void update(Component entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
}
