package com.libtest.libsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class LibsystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibsystemApplication.class, args);
	}

}
