package com.silo.backend.domain.model.entity.user;

import java.util.Set;

import org.hibernate.annotations.NaturalId;

import com.silo.backend.domain.enums.RoleEnum;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table (name = "Role")
public class Role {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Enumerated(EnumType.STRING)
    @NaturalId
    private RoleEnum name;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;
}
