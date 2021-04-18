package com.capgemini.exception;

//Exception if Given Course Id is not present in the database
public class CourseIdNotFoundException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CourseIdNotFoundException(String message)
	{
		super(message);
	}

}
