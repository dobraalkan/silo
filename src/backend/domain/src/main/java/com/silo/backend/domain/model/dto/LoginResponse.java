package com.silo.backend.domain.model.dto;

import java.util.Map;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginResponse {

    private Map<String, Object> map;
    
}
