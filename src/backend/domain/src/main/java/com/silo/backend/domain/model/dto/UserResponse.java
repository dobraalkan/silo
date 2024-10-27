package com.silo.backend.domain.model.dto;

import java.util.Set;

import com.silo.backend.domain.model.entity.user.Role;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponse {
    
    private Long id;
    private String email;
    private String firstName;
    private Set<Role> roles;
    private String provider;
    private String lastName;
  
}
