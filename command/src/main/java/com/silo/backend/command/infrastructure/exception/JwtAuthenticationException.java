package com.silo.backend.command.infrastructure.exception;

import javax.naming.AuthenticationException;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class JwtAuthenticationException extends AuthenticationException {

    private HttpStatus httpStatus;

    public JwtAuthenticationException(String msg) {
        super(msg);
    }

    public JwtAuthenticationException(String msg, HttpStatus httpStatus) {
        super(msg);
        this.httpStatus = httpStatus;
    }
}
