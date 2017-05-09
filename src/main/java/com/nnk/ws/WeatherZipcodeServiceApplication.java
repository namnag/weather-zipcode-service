package com.nnk.ws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.nnk.aspect.LoggingAspect;

@ComponentScan
@SpringBootApplication
@EnableAspectJAutoProxy
public class WeatherZipcodeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherZipcodeServiceApplication.class, args);
	}
	
	 @Bean   
	    public LoggingAspect myLogger(){
	       return new LoggingAspect();
	    }
	
}
