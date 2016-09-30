package com.nnk.ws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@SpringBootApplication
public class WeatherZipcodeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherZipcodeServiceApplication.class, args);
	}
	
}
