package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@RestController
public class ClientController {

	
	@Autowired
	private RestTemplate template;
	
	@GetMapping(path = "/client/{id}")
	@HystrixCommand(fallbackMethod = "fetchCustomerFallBack")
	
	public String fetchCustomerDetails(@PathVariable("id") int id) {
		
		String URI = "http://customer-service/customers/"+id;
		return this.template.getForObject(URI, String.class);
	}
	
   public String fetchCustomerFallBack( int id) {
		
			return "{id:0,name:Guest}";
	}
	
}
