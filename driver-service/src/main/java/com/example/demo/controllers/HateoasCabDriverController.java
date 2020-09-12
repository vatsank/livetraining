package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Driver;
import com.example.demo.repos.CabDriverHateoasRepository;

@RestController

public class HateoasCabDriverController {

	@Autowired
	private CabDriverHateoasRepository service;


	@GetMapping(path = "/api/v2/drivers",produces = "application/hal+json")
	public List<Driver> getAllDriver(){
		
		return this.service.findAll();
	}
	

	@GetMapping(path = "/api/v2/drivers/{location}",produces = "application/hal+json")
	public List<Driver> getDriverByLocataion(@PathVariable("location") String location){
		
		return this.service.findByLocation(location);
	}
}
