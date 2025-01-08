package com.silo.backend.command.domain.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class OAuth2Principal {
    
    String id;
    String email;
    String firstName;
    String lastName;
    String imageUrl;
    String provider;

}
