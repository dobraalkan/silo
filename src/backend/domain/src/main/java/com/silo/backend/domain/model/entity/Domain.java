package com.silo.backend.domain.model.entity;

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
