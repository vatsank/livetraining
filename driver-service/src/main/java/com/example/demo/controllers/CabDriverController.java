package com.example.demo.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

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
	
	@GetMapping(path = "/api/v1/drivers/sorted/{key}",produces = "application/json")
	public List<Driver> sortedList(@PathVariable("key") String key){
		
		return this.service.sortedList(key);
	}
	
	@PostMapping(path = "/api/v1/drivers",consumes="application/json",
			                              produces = "application/json")
	@ResponseStatus(value = HttpStatus.CREATED)
	public Driver addDriver(@RequestBody Driver entity){
		
		return this.service.addDriver(entity);
	}
	
	
	@PutMapping(path = "/api/v1/drivers",consumes="application/json",
            produces = "application/json")
    public Driver updateDriver(@RequestBody Driver entity){

     return this.service.updateDriver(entity);
    }
	
	
	@DeleteMapping(path = "/api/v1/drivers",consumes="application/json",
            produces = "application/json")
public Driver deleteDriver(@RequestBody Driver entity,HttpServletResponse resp){

            Driver driver = this.service.deleteDriver(entity);
            
            if(driver==null) {
            	
            	throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Requested Entity Not Found in table");
            } 
            
            return driver;
}
	
}
