package com.example.famesphere;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class FamesphereApplication {

	// Famesphere
	public static void main(String[] args) {
		SpringApplication.run(FamesphereApplication.class, args);
	}

}
