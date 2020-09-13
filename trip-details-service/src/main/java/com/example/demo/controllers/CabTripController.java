package com.example.demo.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin(origins = "*")
@Slf4j
public class CabTripController {

	
	
	public CabTripController() {
		super();
		log.info("Cab Trip controller Initialized");

	}

	@GetMapping(path = "/message")
	public String message() {
		
		log.info("Cab Trip controller Message Method Called");
		
		return "Details will be shown shortly";
	}
}
