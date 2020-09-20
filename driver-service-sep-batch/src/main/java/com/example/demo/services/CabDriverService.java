package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

}
