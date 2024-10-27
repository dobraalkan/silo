package com.silo.backend.application.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.silo.backend.domain.mapper.Mapper;
import com.silo.backend.domain.model.dto.PasswordResetRequest;
import com.silo.backend.domain.model.dto.RegistrationRequest;
import com.silo.backend.domain.model.dto.UserPrincipal;
import com.silo.backend.domain.model.dto.UserResponse;
import com.silo.backend.domain.model.dto.UserUpdateRequest;
import com.silo.backend.domain.model.entity.user.User;
import com.silo.backend.infrastructure.ErrorMessage;
import com.silo.backend.infrastructure.exception.ApiRequestException;
import com.silo.backend.infrastructure.exception.InputFieldException;
import com.silo.backend.service.UserService;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.mail.MessagingException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * REST controller for managing {@link User}.
 *
 * @author
 */
@RestController
@RequestMapping("/api/user")
@Tag(name = "User API", description = "Kullanici islemleri")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<UserResponse> getUser(@AuthenticationPrincipal UserPrincipal user) {
        User usr = userService.getByEmail(user.getEmail())
                .orElseThrow(() -> new ApiRequestException(ErrorMessage.EMAIL_NOT_FOUND, HttpStatus.NOT_FOUND));

        return ResponseEntity.ok(Mapper.convertToResponse(usr, UserResponse.class));
    }

    @PutMapping
    public ResponseEntity<UserResponse> updateUser(@AuthenticationPrincipal UserPrincipal user,
            @Valid @RequestBody UserUpdateRequest request, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new InputFieldException(bindingResult);
        }
        User usr = Mapper.convertToEntity(request, User.class);
        return ResponseEntity
                .ok(Mapper.convertToResponse(userService.update(user.getEmail(), usr), UserResponse.class));
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@Valid @RequestBody RegistrationRequest request,
            BindingResult bindingResult) throws MessagingException {
        if (bindingResult.hasErrors()) {
            throw new InputFieldException(bindingResult);
        }

        User user = Mapper.convertToEntity(request, User.class);

        return ResponseEntity.ok(userService.registerUser(user, request.getCaptcha(), request.getPassword2()));
    }

    @GetMapping("/activate")
    public ResponseEntity<String> activateEmailCode(@PathVariable String code) {
        return ResponseEntity.ok(userService.activateUser(code));
    }

    @GetMapping("/forgot/{email}")
    public ResponseEntity<String> forgotPassword(@PathVariable String email) throws MessagingException {
        return ResponseEntity.ok(userService.sendPasswordResetCode(email));
    }

    @GetMapping("/reset/{code}")
    public ResponseEntity<String> getEmailByPasswordResetCode(@PathVariable String code) {
        return ResponseEntity.ok(userService.getEmailByPasswordResetCode(code));
    }

    @PostMapping("/reset")
    public ResponseEntity<String> passwordReset(@RequestBody PasswordResetRequest passwordReset) {
        return ResponseEntity.ok(userService.passwordReset(passwordReset.getEmail(), passwordReset.getPassword(),
                passwordReset.getPassword2()));
    }

    @PutMapping("/edit/password")
    public ResponseEntity<String> updateUserPassword(@AuthenticationPrincipal UserPrincipal user,
            @Valid @RequestBody PasswordResetRequest passwordReset, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            throw new InputFieldException(bindingResult);
        } else {
            return ResponseEntity.ok(userService.passwordReset(user.getEmail(), passwordReset.getPassword(),
                    passwordReset.getPassword2()));
        }
    }
}
