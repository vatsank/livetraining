package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@CrossOrigin(origins = "*")
public class ControllerWithLoadBalancer {

	
	@Autowired
	@Qualifier("template2")
	private RestTemplate template2;
	
	@Autowired
	private LoadBalancerClient client;
	
	@GetMapping(path = "/api/v2/tax/{pan}",produces = "application/json")
	public String getDetailsByPan(@PathVariable("pan") String pan) {
		
	  ServiceInstance selectedInstance =   this.client.choose("TAX-DETAILS-SERVICE");
		
	    String baseURL = selectedInstance.getUri().toString();
		
	    String url = baseURL+"/api/v1/taxdetails/"+pan;

	    
		return template2.getForObject(url, String.class);
	}
}
