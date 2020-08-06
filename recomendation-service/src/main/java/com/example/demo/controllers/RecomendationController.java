package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Recomedation;

@RestController
public class RecomendationController {

	
	@Autowired
	private Recomedation bean;
	
	@Value("${server.port}")
	private String port;
	
	
	@GetMapping(path = "/api/v1/suggestions")
	public Recomedation getSuggestions() {
		
		  bean.setId(Integer.parseInt(port));
		  
		  return bean;
	}
}
