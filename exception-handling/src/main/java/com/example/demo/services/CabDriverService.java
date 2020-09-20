package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exceptions.MyResourceNotFoundException;
import com.example.demo.model.Driver;
import com.example.demo.repos.CabDriverRepository;

@Service
public class CabDriverService {

	
	@Autowired
	private CabDriverRepository repo;


	public List<Driver> getAllDriver(){
		
		return this.repo.findAll();
	}


	public Driver getDriverById(int id){
		
      return this.repo.findById(id).orElseThrow(RuntimeException::new);
	   
}
	
	public Driver getDriverByIdWithException(int id) throws MyResourceNotFoundException{
		
		     
	Optional<Driver> optionalDriver  =	this.repo.findById(id);
	
    return  optionalDriver.orElseThrow(() -> new MyResourceNotFoundException("Username or password wrong"));

	      
	}
}