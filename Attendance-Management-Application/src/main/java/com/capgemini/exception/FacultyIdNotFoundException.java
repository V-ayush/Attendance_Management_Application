package com.capgemini.exception;

//Exception if Given Faculty Id is present in the database
public class FacultyIdNotFoundException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public FacultyIdNotFoundException(String msg) {
		super(msg);
	}

}
