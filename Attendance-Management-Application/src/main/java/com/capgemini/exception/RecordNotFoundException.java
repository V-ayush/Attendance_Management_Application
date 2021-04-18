package com.capgemini.exception;


//Exception if given record is already present in the database
public class RecordNotFoundException extends Exception
{
	private static final long serialVersionUID = 1L;

	public RecordNotFoundException(String message) {
		super(message);
	
	}
}
