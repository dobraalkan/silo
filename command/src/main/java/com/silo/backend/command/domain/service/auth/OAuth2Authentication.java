package com.silo.backend.command.domain.service.auth;

import com.silo.backend.command.domain.model.entity.OAuth2Principal;

public interface OAuth2Authentication {
    OAuth2Principal authenticate(String anAccessCode);
}