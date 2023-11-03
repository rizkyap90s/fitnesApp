package com.ky.fitnesApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class FitnesAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(FitnesAppApplication.class, args);
	}

}
