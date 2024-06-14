package com.cognizant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.cognizant.*")
@EnableJpaRepositories(basePackages = "com.cognizant.repositories")
@EntityScan(basePackages = "com.cognizant.entities")
public class HrNavigatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrNavigatorApplication.class, args);
	}

}
