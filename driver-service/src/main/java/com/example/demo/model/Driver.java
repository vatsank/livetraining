package com.example.demo.model;



import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


import org.hibernate.validator.constraints.Length;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "sep_driver")
public class Driver {

	
	@Id
	int driverId;
	@Length(max = 10,min = 3,message = "Driver Name should be 3 to 8 chars")
	String driverName;
	
	long mobileNumber;
	
	String location;
	
	@Embedded
	Address address;
}
