package com.silo.backend.command.infrastructure.security;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class UserAuthToken extends AbstractAuthenticationToken {

    private UserAuthPrincipal userPrincipal;

    public UserAuthToken(UserAuthPrincipal userPrincipal) {
        super(userPrincipal.getAuthorities());
        super.setAuthenticated(true);
        this.userPrincipal = userPrincipal;
    }

    public UserAuthToken(String authToken, Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.setAuthenticated(true);
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return userPrincipal;
    }
}
