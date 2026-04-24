package com.genos.sindeps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SindepsApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SindepsApplication.class, args);
	}

}
