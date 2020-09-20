package com.example.demo.exceptions;

public class MyResourceNotFoundException extends Exception {

	String message;
	Throwable cause;
	
	public MyResourceNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	public MyResourceNotFoundException(String message, Throwable cause) {
		
	     this.cause = cause;
		 this.message=message;
	}
	@Override
	public String getMessage() {
		return super.getMessage() + this.getMessage();
	}

	
}
