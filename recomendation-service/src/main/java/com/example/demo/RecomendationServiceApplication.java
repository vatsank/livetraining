package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.entity.Recomedation;

@SpringBootApplication
public class RecomendationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecomendationServiceApplication.class, args);
	}

	@Bean
	public Recomedation bean() {
		
		Recomedation bean = new Recomedation();
		 bean.setDescription("Housing Loan-7.2% , Personal Loan-4%");
		 
		 return bean;
		
	}
}
