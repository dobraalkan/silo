package com.silo.backend.service;

import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.silo.backend.domain.model.dto.UserPrincipal;
import com.silo.backend.domain.model.entity.user.User;
import com.silo.backend.domain.repository.UserRepository;
import com.silo.backend.infrastructure.ErrorMessage;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException(ErrorMessage.USER_NOT_FOUND));
        if (user.getActivationCode() != null) {
            throw new LockedException(ErrorMessage.EMAIL_NOT_ACTIVATED);
        }
        return UserPrincipal.create(user);
    }
}
