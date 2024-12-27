package com.lead_management_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class LeadManagementSystemApplication {

	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.load();
		System.setProperty("POSTGRES_DB_USERNAME", dotenv.get("POSTGRES_DB_USERNAME"));
		System.setProperty("POSTGRES_DB_PASSWORD", dotenv.get("POSTGRES_DB_PASSWORD"));
		SpringApplication.run(LeadManagementSystemApplication.class, args);
	}

}
