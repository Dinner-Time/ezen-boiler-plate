package com.ezen.boilerplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BoilerPlateApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoilerPlateApplication.class, args);
	}

}
