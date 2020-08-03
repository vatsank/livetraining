package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.entity.Address;
import com.example.demo.entity.Customer;

@Configuration
public class AppConfig {

	@Bean
	public Address address() {
		
		return new Address("Gandhi Street","Nehru Nagar","balewadi",202022);
	}
	
	@Bean
	public Customer customer() {
		
		// Passing Reference of another Bean
		
		return new Customer(102,"Vaibav","Sawant",address());
	}
}
