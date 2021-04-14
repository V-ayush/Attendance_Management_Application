package com.capgemini.service;

import com.capgemini.entity.FacultyEntity;

public interface FacultyService {
	
	public FacultyEntity addFaculty(FacultyEntity entity);
	
	public FacultyEntity updateFaculty(FacultyEntity entity);
	
	public String deleteFaculty(FacultyEntity entity);
}
