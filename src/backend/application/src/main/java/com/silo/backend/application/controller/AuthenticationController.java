package com.silo.backend.application.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.silo.backend.domain.mapper.Mapper;
import com.silo.backend.domain.model.dto.AuthenticationRequest;
import com.silo.backend.domain.model.dto.AuthenticationResponse;
import com.silo.backend.domain.model.dto.LoginResponse;
import com.silo.backend.domain.model.dto.UserResponse;
import com.silo.backend.service.AuthenticationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * REST controller for managing {@link Authentication}.
 *
 * @author
 */
@RestController
@RequestMapping("/api/auth")
@Tag(name = "Authentication API", description="Authentication islemleri")
@RequiredArgsConstructor
@Slf4j
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest request) {
        LoginResponse credentials = authenticationService.login(request.getEmail(), request.getPassword());
        AuthenticationResponse response = new AuthenticationResponse();
        response.setUser(Mapper.convertToResponse(credentials.getMap().get("user"), UserResponse.class));
        response.setToken((String) credentials.getMap().get("token"));

        return ResponseEntity.ok(response);
    }
}
