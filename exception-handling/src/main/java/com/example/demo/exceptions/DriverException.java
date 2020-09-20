package com.example.demo.exceptions;

import com.example.demo.model.Address;
import com.example.demo.model.Driver;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DriverException {

	private int errorCode;
    private String message;

}
