package com.example;

import com.example.demo.DemoApplication;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @SpringBootApplication(scanBasePackages = "com.Example.demo")

@SpringBootApplication
@MapperScan("com.example.demo.mapper")
public class BaseMybatisGeneratorSwagger {

	public static void main(String[] args) {
		SpringApplication.run(BaseMybatisGeneratorSwagger.class, args);
	}

}