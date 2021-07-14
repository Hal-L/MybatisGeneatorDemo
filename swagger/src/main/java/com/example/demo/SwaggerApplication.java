package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @SpringBootApplication(scanBasePackages = "com.Example.demo")

@SpringBootApplication
public class SwaggerApplication {


	@Value("${spring.datasource.url}")
	private static String str;

	public static void main(String[] args) {
		SpringApplication.run(SwaggerApplication.class, args);
	}

}
