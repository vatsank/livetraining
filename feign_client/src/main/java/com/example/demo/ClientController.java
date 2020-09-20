package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

	
	@Autowired
	MyClient feign;

	@GetMapping(path = "/clients")
	public String getAll() {
		
		return this.feign.getAllDriver();
	}

}
