package com.capgemini.exception;


//Exception if Given Student is not present in the database
public class StudentNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;

	public StudentNotFoundException(String msg) {
		super(msg);
	}
	
}
