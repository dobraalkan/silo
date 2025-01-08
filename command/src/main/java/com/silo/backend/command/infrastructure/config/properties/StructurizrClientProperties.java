package com.silo.backend.command.infrastructure.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "structurizr.client")
public record StructurizrClientProperties(String endpoint, String key, String secret) {
    
}
