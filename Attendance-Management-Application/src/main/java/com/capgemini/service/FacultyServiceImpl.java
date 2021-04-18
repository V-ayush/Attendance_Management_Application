package com.capgemini.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.entity.FacultyEntity;
import com.capgemini.exception.FacultyIdNotFoundException;
import com.capgemini.exception.RecordNotFoundException;
import com.capgemini.repository.FacultyRepository;

@Service
public class FacultyServiceImpl implements FacultyService {
		
	@Autowired
	FacultyRepository facultyRepository;
	
	//For Adding the details of the faculty
	@Override
	public FacultyEntity addFaculty(FacultyEntity entity)
		{
			return facultyRepository.save(entity);
		}

	//For Getting the faculty details by faculty ID
	@Override
	public FacultyEntity getFacultyById(int facultyId) 
			throws FacultyIdNotFoundException
		{
			Supplier<FacultyIdNotFoundException> supplier=()->new FacultyIdNotFoundException("Given Faculty Id is not present in the Database");
			return facultyRepository.findById(facultyId).orElseThrow(supplier);
		}

	//For Deleting the Faculty Entity by using faculty Id
	@Override
	public String deleteFacultyById(int facultyId) 
			throws RecordNotFoundException
		{
			Supplier<RecordNotFoundException> supplier=()->new RecordNotFoundException("No such Record Found");
			facultyRepository.findById(facultyId).orElseThrow(supplier);
			facultyRepository.deleteById(facultyId);
			return "Deleted by Id";	
		}

	//For getting the details of the all the faculty
	@Override
	public List<FacultyEntity> getAllFaculty() 
			throws RecordNotFoundException
		{
			List<FacultyEntity> facultyDetails = new ArrayList<FacultyEntity>();
			facultyDetails = facultyRepository.findAll();		
			if(facultyDetails.isEmpty())
					throw new RecordNotFoundException("Record Not In The Database");
			return facultyDetails;
		}

	//For updating the faculty details by using faculty Id
	@Override
	public FacultyEntity updateFacultyById(int facultyId, FacultyEntity entity) 
			throws FacultyIdNotFoundException
		{
			Supplier<FacultyIdNotFoundException> supplier=()->new FacultyIdNotFoundException("Given Id Is Not Present");
			FacultyEntity facultyDetails = facultyRepository.findById(facultyId).orElseThrow(supplier);
			entity.setFacultyName(entity.getFacultyName());
			facultyRepository.save(facultyDetails);
			return facultyDetails;
		}
	
	//For Getting the faculty details by checking the faculty name
	 @Override 
	 public List<FacultyEntity> findByfacultyName(String facultyName) 
			 throws RecordNotFoundException
	 	{
		 	List<FacultyEntity> facultyDetails = facultyRepository.findByfacultyNameIgnoreCaseContains(facultyName);
		 	if(facultyDetails.isEmpty())
		 			throw new RecordNotFoundException("Record Not In The Database");
		 	return facultyDetails;
	 	}
	 
	 @Override
		public boolean getFacultyExistById(int facultyId)
	 	{
		 	return facultyRepository.existsById(facultyId);
		}
	
}

