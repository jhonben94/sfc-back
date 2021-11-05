package com.py.sfc.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SfcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SfcApplication.class, args);
	}

}
