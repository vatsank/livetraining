package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeedBackController {

	
	@Value("${server.port}")
	private String reviews;
	
	@GetMapping(path = "/reviews")
	public String getReviews() {
		
		
		return "Reveiwed by : ="+this.reviews ;
	}
}
