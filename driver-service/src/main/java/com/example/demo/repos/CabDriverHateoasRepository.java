package com.example.demo.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.example.demo.model.Driver;

@RepositoryRestResource
public interface CabDriverHateoasRepository extends JpaRepository<Driver, Integer> {

	// Custom Query Method following a pattern findByxxx here xxx stands for
	// property name as defined in our Entity Class
	@RestResource(path = "location" ,rel = "custom")
	public List<Driver> findByLocation(@Param("location") String location);
}



