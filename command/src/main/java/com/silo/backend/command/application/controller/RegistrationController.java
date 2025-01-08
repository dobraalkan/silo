package com.silo.backend.command.application.controller;

import com.silo.backend.command.application.controller.RestApiRoutes.RegistrationRoutes;
import com.silo.backend.command.application.recovery.command.CreatePasswordRecoveryCodeCommand;
import com.silo.backend.command.application.recovery.command.UpdatePasswordWithRecoveryCodeCommand;
import com.silo.backend.command.application.registration.command.ConfirmUserRegistrationCommand;
import com.silo.backend.command.application.registration.command.RegisterNewUserCommand;
import com.silo.backend.command.infrastructure.base.BaseController;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/")
@Tag(name = "Registration API", description = "Kullanıcı kayıt islemleri")
@RequiredArgsConstructor
@Slf4j
public class RegistrationController extends BaseController {

    @PostMapping(RegistrationRoutes.FORM_REGISTRATION)
    public void formRegister(@RequestBody @Validated RegisterNewUserCommand command) {
        ResponseEntity.ok(executeCommand(command));
    }

    @PostMapping(RegistrationRoutes.CONFIRM_REGISTRATION)
    public void formRegisterConfirmation(@RequestParam String confirmationCode) {
        ResponseEntity.ok(executeCommand(new ConfirmUserRegistrationCommand(confirmationCode)));
    }

    @PatchMapping(RegistrationRoutes.CREATE_PASSWORD_RECOVERY_CODE)
    public void formRegisterRecovery(@RequestBody @Validated CreatePasswordRecoveryCodeCommand command) {
        ResponseEntity.ok(executeCommand(command));
    }

    @PatchMapping(RegistrationRoutes.PASSWORD_RESET)
    public void passwordReset(@RequestBody @Validated UpdatePasswordWithRecoveryCodeCommand command) {
        ResponseEntity.ok(executeCommand(command));
    }
}
