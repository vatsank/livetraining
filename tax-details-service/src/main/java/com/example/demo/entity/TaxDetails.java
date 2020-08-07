package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "taxdetails_august")
@AllArgsConstructor
@Slf4j
public class TaxDetails {

	 @Id
	 String panNumber;
	 String entityName;
	 String entityType;
	 String aadharNumber;
	public TaxDetails() {
		super();
		log.info("Tax Details Constructor Called");
	}
	 
	 
}
