package com.silo.backend.command.application.controller;

import com.silo.backend.command.application.controller.RestApiRoutes.User;
import com.silo.backend.command.application.users.command.ChangeUserDetailsCommand;
import com.silo.backend.command.application.users.dto.BaseUserDto;
import com.silo.backend.command.application.users.query.GetUserQuery;
import com.silo.backend.command.infrastructure.base.BaseController;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(path = "/")
@Tag(name = "User API", description = "Kullanıcı islemleri")
@Slf4j
public class UserController extends BaseController {

    @GetMapping(User.USER_DETAILS)
    public ResponseEntity<BaseUserDto> user(@PathVariable(value = "userId") String userId) {
        return ResponseEntity.ok(executeQuery(new GetUserQuery(userId)));
    }

    @PatchMapping(User.USER_DETAILS)
    public ResponseEntity<BaseUserDto> user(@PathVariable(value = "userId") UUID userId, @RequestBody @Validated ChangeUserDetailsCommand command) {
        command.setUserId(userId);
        executeCommand(command);

        return new ResponseEntity<BaseUserDto>((BaseUserDto)executeCommand(command),HttpStatus.OK);
    }
}
