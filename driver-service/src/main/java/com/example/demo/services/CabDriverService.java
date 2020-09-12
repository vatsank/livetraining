package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.Driver;
import com.example.demo.repos.CabDriverRepository;

@Service
public class CabDriverService {

	
	@Autowired
	private CabDriverRepository repo;


	public List<Driver> getAllDriver(){
		
		return this.repo.findAll();
	}

	public Driver addDriver(Driver entity) {
		
		return this.repo.save(entity);
	}
	
	
	public Driver updateDriver(Driver entity) {
		
		return this.addDriver(entity);
	}
	
	
	public Driver deleteDriver(Driver entity) {
		
		Driver deleted = null;
		
		if(repo.existsById(entity.getDriverId())) {
			
			repo.delete(entity);
			
			deleted = entity;
		} 
		
		return deleted;
	}
	
	public List<Driver> sortedList(String propName){
		
		
		   return this.repo.findAll(Sort.by(propName).descending());
		   
	}
}
