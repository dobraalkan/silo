package com.silo.backend.command.infrastructure.springboot;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.silo.backend.command.infrastructure.exception.ApiRequestException;
import com.silo.backend.command.infrastructure.exception.CaptchaException;
import com.silo.backend.command.infrastructure.exception.EmailException;
import com.silo.backend.command.infrastructure.exception.InputFieldException;
import com.silo.backend.command.infrastructure.exception.PasswordConfirmationException;
import com.silo.backend.command.infrastructure.exception.PasswordException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ApiRequestException.class)
    public ResponseEntity<String> handleApiRequestException(ApiRequestException exception) {
        return ResponseEntity.status(exception.getStatus()).body(exception.getMessage());
    }

    @ExceptionHandler(PasswordConfirmationException.class)
    public ResponseEntity<PasswordConfirmationException> handlePasswordConfirmationException(PasswordConfirmationException exception) {
        return ResponseEntity.badRequest().body(new PasswordConfirmationException(exception.getPassword2Error()));
    }

    @ExceptionHandler(PasswordException.class)
    public ResponseEntity<PasswordException> handlePasswordException(PasswordException exception) {
        return ResponseEntity.badRequest().body(new PasswordException(exception.getPasswordError()));
    }

    @ExceptionHandler(EmailException.class)
    public ResponseEntity<EmailException> handleEmailError(EmailException exception) {
        return ResponseEntity.badRequest().body(new EmailException(exception.getEmailError()));
    }

    @ExceptionHandler(CaptchaException.class)
    public ResponseEntity<CaptchaException> handleCaptchaException(CaptchaException exception) {
        return ResponseEntity.badRequest().body(new CaptchaException(exception.getCaptchaError()));
    }

    @ExceptionHandler(InputFieldException.class)
    public ResponseEntity<Map<String, String>> handleInputFieldException(InputFieldException exception) {
        InputFieldException inputFieldException = new InputFieldException(exception.getBindingResult());
        return ResponseEntity.badRequest().body(inputFieldException.getErrorsMap());
    }
    
}
