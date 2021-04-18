package com.capgemini.exception;

//Exception if  given subject is not present in the database
public class SubjectNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;

	public SubjectNotFoundException(String msg) {
		super(msg);
	}
	
}