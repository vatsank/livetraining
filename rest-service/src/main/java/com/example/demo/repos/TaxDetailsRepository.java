package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.TaxDetails;

public interface TaxDetailsRepository extends JpaRepository<TaxDetails, String> {

}
