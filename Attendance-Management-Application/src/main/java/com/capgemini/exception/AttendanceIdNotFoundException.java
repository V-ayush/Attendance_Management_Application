package com.capgemini.exception;

//Exception if Given Attendance Id Is NOt Present In The Database
public class AttendanceIdNotFoundException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AttendanceIdNotFoundException(String message)
	{
		super(message);
	}

}
