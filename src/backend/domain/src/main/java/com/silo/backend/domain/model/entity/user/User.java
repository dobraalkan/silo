package com.silo.backend.domain.model.entity.user;

import java.util.Set;

import org.hibernate.annotations.NaturalId;

import com.silo.backend.domain.enums.AuthProviderEnum;
import com.silo.backend.domain.enums.RoleEnum;

import jakarta.annotation.Nullable;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table (name = "user", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
            "email"
        })
})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    
    @NaturalId
    @NotBlank
    @Size(max = 40)
    @Email
    private String email;
    
    @NotBlank
    @Size(max = 100)
    private String password;

    @Size(max = 20)
    private String firstName;

    @Size(max = 20)
    private String lastName;
    
    @Column(name = "activation_code")
    private String activationCode;

    @Column(name = "password_reset_code")
    @Nullable
    private String passwordResetCode;

    @Column(name = "active")
    private boolean active;

    @Column(name = "provider")
    @Enumerated(EnumType.STRING)
    private AuthProviderEnum provider;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<RoleEnum> roles;
    
}
