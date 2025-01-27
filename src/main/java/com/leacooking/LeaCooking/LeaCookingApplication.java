package com.leacooking.LeaCooking;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableJpaRepositories(basePackages = "com.leacooking.LeaCooking.api.repository")
@EntityScan(basePackages = "com.leacooking.LeaCooking.api.entity")
@ConfigurationPropertiesScan("com.leacooking.LeaCooking.api.config.property")
@SpringBootApplication
public class LeaCookingApplication {
	// ---------------------------------- TEMP ----------------------------------
	@Value("${spring.datasource.url}")
	private String dbUrl;

	@PostConstruct
	public void logDbConfig() {
		System.out.println("DB URL: " + dbUrl);
	}
	// ---------------------------------- TEMP ----------------------------------

	public static void main(String[] args) {
		SpringApplication.run(LeaCookingApplication.class, args);
	}

}
