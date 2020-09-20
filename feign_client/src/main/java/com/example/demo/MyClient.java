package com.example.demo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("driver-service")
public interface MyClient {

	
	@GetMapping(path = "/api/v1/drivers")
	public String getAllDriver();
}
