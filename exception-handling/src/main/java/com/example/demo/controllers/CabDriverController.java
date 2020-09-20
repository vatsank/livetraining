package com.example.demo.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.exceptions.MyResourceNotFoundException;
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
	
	@GetMapping(path = "/api/v1/drivers/{id}",produces = "application/json")
	public Driver findDriverById(@PathVariable("id") int id){
		
		return this.service.getDriverById(id);
	}
	
	@GetMapping(value = "/api/v2/drivers/{id}")
	public Driver findById(@PathVariable("id") int id, HttpServletResponse response) {
	    try {
	        Driver driver= service.getDriverByIdWithException(id);
	 
	       return driver;
	     }
	    catch (MyResourceNotFoundException exc) {
	         throw new ResponseStatusException(
	           HttpStatus.NOT_FOUND, "Required  Element with Id"+id +"not found", exc);
	    }
	}
}
