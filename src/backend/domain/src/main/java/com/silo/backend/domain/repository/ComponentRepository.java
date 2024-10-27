package com.silo.backend.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.silo.backend.domain.model.entity.Component;

@Repository
public interface ComponentRepository extends JpaRepository<Component,String> {

    
} 