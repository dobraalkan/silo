package com.silo.backend.query;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories (basePackages = "com.silo.backend.query.domain.repository")
@EntityScan (basePackages = "com.silo.backend.query.domain.model.entity")
@ComponentScan ({"com.silo.backend.query.application.controller","com.silo.backend.service"})
@EnableAutoConfiguration
public class QueryApplication {

	public static void main(String[] args) {
		SpringApplication.run(QueryApplication.class, args);
	}

}
