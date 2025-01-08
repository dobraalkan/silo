package com.silo.backend.command.domain.model.entity;

import com.silo.backend.command.infrastructure.base.BaseEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table (name = "Domain")
public class Domain extends BaseEntity {
    
}
