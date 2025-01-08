package com.silo.backend.command.application.dto;

import lombok.Getter;

@Getter
public class RecoveryPasswordDto implements Response {

    String recoveryCode;

    public RecoveryPasswordDto(String recoveryCode) {
        this.recoveryCode = recoveryCode;
    }
}
