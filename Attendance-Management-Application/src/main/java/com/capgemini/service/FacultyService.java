package com.capgemini.service;

import java.util.List;

import com.capgemini.entity.FacultyEntity;
import com.capgemini.exception.FacultyIdNotFoundException;
import com.capgemini.exception.RecordNotFoundException;

public interface FacultyService {
	
	//For Adding the details of the faculty
	public FacultyEntity addFaculty(FacultyEntity entity);
	
	//For Getting the faculty details by faculty ID
	public FacultyEntity getFacultyById(int facultyId) throws FacultyIdNotFoundException;

	//For Deleting the Faculty Entity by using faculty Id
	public String deleteFacultyById(int facultyId) throws RecordNotFoundException;
	
	//For getting the details of the all the faculty
	public List<FacultyEntity> getAllFaculty() throws RecordNotFoundException;

	//For updating the faculty details by using faculty Id
	public FacultyEntity updateFacultyById(int facultyId, FacultyEntity se) throws FacultyIdNotFoundException;
	
	//For Getting the faculty details by checking the faculty name
	public List<FacultyEntity> findByfacultyName(String facultyName) throws RecordNotFoundException;
	
	public boolean getFacultyExistById(int facultyId);
}
