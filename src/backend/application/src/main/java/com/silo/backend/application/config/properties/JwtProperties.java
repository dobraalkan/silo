package com.silo.backend.application.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@ConfigurationProperties(prefix = "jwt")
@Setter
@Getter
public class JwtProperties {
    private String issuer;
    private String secretKey;
}
