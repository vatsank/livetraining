package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Driver;
import com.example.demo.services.CabDriverService;

@RestController
public class CabDriverController {

	
	@Autowired
	private CabDriverService service;


	@GetMapping(path = "/api/v1/drivers",produces = "application/json")
	public List<Driver> getAllDriver(){
		
		return this.service.getAllDriver();
	}
}
