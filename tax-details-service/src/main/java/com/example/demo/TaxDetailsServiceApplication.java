package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import com.netflix.client.config.DefaultClientConfigImpl;
import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;

@SpringBootApplication
@EnableDiscoveryClient
public class TaxDetailsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaxDetailsServiceApplication.class, args);
	}


//	@Bean
//	public  IClientConfig config() {
//		
//		return new DefaultClientConfigImpl();
//	};
//	
//	
//	@Bean
//	public IRule rule(IClientConfig config) {
//	
//		//return new BestAvailableRule();
//		
//		return new RoundRobinRule();
//	}
}
