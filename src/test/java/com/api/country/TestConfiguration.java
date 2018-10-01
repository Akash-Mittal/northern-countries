package com.api.country;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = { "com.api.country" })
@SpringBootApplication
public class TestConfiguration {
	public static void main(String[] args) {
		SpringApplication.run(TestConfiguration.class, args);
	}
}