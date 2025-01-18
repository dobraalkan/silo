package com.silo.backend.command;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories (basePackages = "com.silo.backend.command.infrastructure.persistence.jpa")
@EntityScan (basePackages = "com.silo.backend.command.domain.model.entity")
@ComponentScan ({"com.silo.backend.command.application.controller","com.silo.backend.command.domain.service"})
@EnableAutoConfiguration
public class CommandApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommandApplication.class, args);
	}

}
