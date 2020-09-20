package com.example.demo;

import org.config.ribbon.MyRibbonConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.HystrixCommandGroupKey;

@SpringBootApplication
@EnableHystrix
@RibbonClient(name = "customer-service", configuration = MyRibbonConfiguration.class)
public class CustomerServiceRibbonClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceRibbonClientApplication.class, args);
	}

	
	@Bean
	@LoadBalanced
	public RestTemplate template() {
		
		return new RestTemplate();
	}
	
	@Bean
	public HystrixCommandGroupKey key() {
		
		return new HystrixCommandGroupKey() {
			
			@Override
			public String name() {
				// TODO Auto-generated method stub
				return "Demo";
			}
		};
	}
}
