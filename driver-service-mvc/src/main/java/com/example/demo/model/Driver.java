package com.example.demo.model;


import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Driver {

	
	int driverId;
	@Length(max = 10,min = 3,message = "Driver Name should be 3 to 8 chars")
	String driverName;
	
	long mobileNumber;
	
	String location;
	
	Address address;
}
