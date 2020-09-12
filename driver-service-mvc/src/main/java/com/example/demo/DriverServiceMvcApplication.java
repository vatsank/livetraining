package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.Driver;

@SpringBootApplication
public class DriverServiceMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(DriverServiceMvcApplication.class, args);
	}

	@Bean
	public Driver driver() {
		
		return new Driver();
	}
	
	@Bean
	public RestTemplate template() {
		
		return new RestTemplate();
	}
}
