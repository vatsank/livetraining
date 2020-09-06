package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Driver;

@Repository
public interface CabDriverRepository extends JpaRepository<Driver, Integer> {

}
