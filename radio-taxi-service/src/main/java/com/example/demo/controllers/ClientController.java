package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@CrossOrigin(origins = "*")
public class ClientController {

	
	@Autowired
	private RestTemplate template;
	
	
	@Autowired
	@Qualifier("ribbonTemplate")
	private RestTemplate ribbonTemplate;
	
	
	@Autowired
	private LoadBalancerClient client;
	
	
	@GetMapping(path = "/feedback")
	public String reviews() {
		
		ServiceInstance selected = client.choose("FEEDBACK-SERVICE");
		
		String baseURL = selected.getUri().toString();
		
		String reqURL =baseURL+"/reviews";
		
		
		return this.ribbonTemplate.getForObject(reqURL,String.class);
		
	}
	
	
	@GetMapping(path = "/client")
	public String statement() {
		
		// Here we are using service Discovery and also Logical Identifier to access the 
		// service 
		String baseURL = "http://TRIP-DETAILS-SERVICE/";
		
		String reqURL = baseURL+"message";
		
		
		
		return this.template.getForObject(reqURL, String.class);
	}
}
