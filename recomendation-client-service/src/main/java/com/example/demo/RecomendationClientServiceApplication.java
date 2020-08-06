package com.example.demo;

import org.module.demo.MyRibbonConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.client.RestTemplate;
import org.springframework.context.annotation.*;

@SpringBootApplication
@RibbonClient(name = "suggestion-service",configuration = MyRibbonConfig.class)
public class RecomendationClientServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecomendationClientServiceApplication.class, args);
	}

	
	@Bean
	@LoadBalanced
	public RestTemplate tempate() {
		
		return new RestTemplate();
	}
}
