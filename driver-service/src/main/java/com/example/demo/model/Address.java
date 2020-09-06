package com.example.demo.model;

import javax.persistence.Embeddable;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)

@Embeddable
public class Address {

	
	private String addressLine1;
	private String addressLine2;
	private String city;
	private long pinCode;
	
}
