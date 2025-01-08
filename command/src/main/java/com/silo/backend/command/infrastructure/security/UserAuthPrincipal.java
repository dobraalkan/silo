package com.silo.backend.command.infrastructure.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.silo.backend.command.application.dto.SessionDto;

import java.util.ArrayList;
import java.util.Collection;

public class UserAuthPrincipal implements UserDetails {

    private SessionDto session;

    private final Collection<GrantedAuthority> authorities;

    private boolean enabled = true;

    public UserAuthPrincipal(SessionDto session) {
        this.session = session;
        this.authorities = new ArrayList<>();
    }

    public SessionDto getSession() {
        return session;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<>();
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return session.getUserId();
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.enabled;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.enabled;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.enabled;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }
}
