package com.capgemini.exception;

//Exception if given data is already present in the database
public class DuplicateRecordException  extends Exception
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DuplicateRecordException(String msg) {
		super(msg);
	}
}
