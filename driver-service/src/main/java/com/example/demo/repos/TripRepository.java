package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Trip;

@Repository
public interface TripRepository extends JpaRepository<Trip, Integer> {

}
