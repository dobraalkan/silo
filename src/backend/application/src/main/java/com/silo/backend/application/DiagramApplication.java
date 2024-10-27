package com.silo.backend.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableJpaRepositories (basePackages = "com.silo.backend.domain.repository")
@EntityScan (basePackages = "com.silo.backend.domain.model.entity")
@ComponentScan ({"com.silo.backend.application.controller","com.silo.backend.service"})
@ComponentScan ()
@EnableAutoConfiguration()
public class DiagramApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiagramApplication.class, args);
	}

}
