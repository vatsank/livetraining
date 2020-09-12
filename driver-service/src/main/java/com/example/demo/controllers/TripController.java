package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Trip;
import com.example.demo.repos.TripRepository;

@RestController

public class TripController {

	@Autowired
	private TripRepository repo;
	
	@GetMapping(path = "/api/v1/trips")
	public CollectionModel<Trip> getTrips(){
		
		List<Trip> list = repo.findAll();
		
		for(Trip eachTrip: list) {
			
	           int id = eachTrip.getDriverId();
	           Link selfLink = WebMvcLinkBuilder.linkTo(CabDriverController.class)
	                  .slash("api/v1/drivers/"+id).withSelfRel();
	        
	           eachTrip.add(selfLink);

		}
		
		Link link = WebMvcLinkBuilder.linkTo(TripController.class)
				 .withSelfRel();
				       CollectionModel<Trip> result =
				        CollectionModel.of(list, link);
				       
				       return result;

	}
}
