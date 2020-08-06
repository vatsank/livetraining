package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ClientController {

	
	@Autowired
	RestTemplate template;
	
	@GetMapping(path = "/client")
	public String getSuggestions() {
		
		String baseURL = "http://suggestion-service";
		
		String url = baseURL+"/api/v1/suggestions";
		
		return this.template.getForObject(url, String.class);
		
	}
}
