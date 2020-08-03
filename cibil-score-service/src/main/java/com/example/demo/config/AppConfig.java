package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.entity.Address;
import com.example.demo.entity.Customer;
import com.example.demo.entity.LoanApplication;

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
	
	@Bean
	public LoanApplication loanApp() {
		
		LoanApplication app =  new LoanApplication();
		 app.setId(999);
		 
		 return app;
	}
}
