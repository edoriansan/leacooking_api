package com.leacooking.LeaCooking;

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

	public static void main(String[] args) {
		SpringApplication.run(LeaCookingApplication.class, args);
	}

}
