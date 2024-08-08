package com.example.mycoreapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.example"})
public class MycoreappApplication {

	public static void main(String[] args) {
		SpringApplication.run(MycoreappApplication.class, args);
	}

}
