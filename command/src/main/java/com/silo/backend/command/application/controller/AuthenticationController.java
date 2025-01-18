package com.silo.backend.command.application.controller;

import com.silo.backend.command.application.authentication.command.EmailLoginCommand;
import com.silo.backend.command.application.authentication.command.SocialLoginCommand;
import com.silo.backend.command.application.authentication.command.LogoutCommand;
import com.silo.backend.command.application.controller.RestApiRoutes.AuthRoutes;
import com.silo.backend.command.application.dto.SessionDto;
import com.silo.backend.command.infrastructure.bus.base.BaseController;
import com.silo.backend.command.infrastructure.security.CurrentUser;
import com.silo.backend.command.infrastructure.security.UserAuthPrincipal;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/")
public class AuthenticationController extends BaseController {

    @PostMapping(AuthRoutes.FORM_LOGIN)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<SessionDto> formLogin(@CurrentUser UserAuthPrincipal user,
            @RequestBody @Validated EmailLoginCommand command) {
        return ResponseEntity.ok(executeCommand(command));
    }

    @PostMapping(AuthRoutes.FACEBOOK_LOGIN)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<SessionDto> facebookLogin(@CurrentUser UserAuthPrincipal user,
            @RequestBody @Validated SocialLoginCommand command){
        return ResponseEntity.ok(executeCommand(command));
    }

    @PostMapping(AuthRoutes.GOOGLE_LOGIN)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<SessionDto> googleLogin(@CurrentUser UserAuthPrincipal user,
            @RequestBody @Validated SocialLoginCommand command) {
        return ResponseEntity.ok(executeCommand(command));
    }

    @PatchMapping(AuthRoutes.LOGOUT)
    public ResponseEntity<String> logout(@CurrentUser UserAuthPrincipal user,
            @RequestBody @Validated LogoutCommand command) {
        if (user == null) {
            return ResponseEntity.badRequest().body("Missing session cookie.");
        }

        return ResponseEntity.ok(executeCommand(command));
    }

}
