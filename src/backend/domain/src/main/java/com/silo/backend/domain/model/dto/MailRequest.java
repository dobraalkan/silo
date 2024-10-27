package com.silo.backend.domain.model.dto;

import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
//@AllArgsConstructor
//@NoArgsConstructor
public class MailRequest {
    
    @JsonAlias(value = "to_email")
    private String toEmail;

    private String subject;

    private String message;

    private String template;

    private Map<String, Object> attributes;

    @JsonAlias(value = "html")
    private boolean isHTML;
    
}