package com.silo.backend.command.application.dto;

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
    String toEmail;

    String subject;

    String message;

    String template;

    Map<String, Object> attributes;

    @JsonAlias(value = "html")
    boolean isHTML;
    
}