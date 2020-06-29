package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication

public class OneToManyForeignKeyApplication {

	public static void main(String[] args) {
		SpringApplication.run(OneToManyForeignKeyApplication.class, args);
	}

}
