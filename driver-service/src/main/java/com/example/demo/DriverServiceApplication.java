package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.model.Trip;
import com.example.demo.repos.TripRepository;

@SpringBootApplication
public class DriverServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DriverServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner() {
		
		return new CommandLineRunner() {
			
			@Autowired
			TripRepository repo;
			@Override
			public void run(String... args) throws Exception {
				
				repo.save(new Trip(102,"cab",101));
				repo.save(new Trip(103,"cab",107));
				
			}
		};
	}
}
