package com.capgemini.service;

import java.util.List;




import com.capgemini.entity.SubjectEntity;
import com.capgemini.exception.CourseIdNotFoundException;
import com.capgemini.exception.DuplicateRecordException;
import com.capgemini.exception.FacultyIdNotFoundException;
import com.capgemini.exception.RecordNotFoundException;
import com.capgemini.exception.SubjectNotFoundException;

public interface SubjectService {
	
	//For Adding the Subject Record
	public SubjectEntity addSubject(SubjectEntity entity) throws DuplicateRecordException;
	
	
	//For getting the subject details by subject Id
	public SubjectEntity getSubjectById(int subjectId) throws SubjectNotFoundException;

	
	//For updating the subject details by using subject Id
	public SubjectEntity updateSubjectById(int subjectId, SubjectEntity fe) throws SubjectNotFoundException;

	
	//For Getting the list of the details of all the subjects
	public List<SubjectEntity> getAllSubjects() throws RecordNotFoundException;
	
	
	//For Deleting the Subject Entity by using subject Id
	public String deleteSubById(int subjectId) throws RecordNotFoundException;

	
	//For Getting the list of Subject details by checking the Name of the subject
	public List<SubjectEntity> findSubjectByName(String subjectName) throws RecordNotFoundException;
	
	
	//For Adding the Subject with respect to Faculty Id & Course Id
	public SubjectEntity addSubjectwithFC(SubjectEntity entity, int facultyId, int courseId)
			throws FacultyIdNotFoundException, CourseIdNotFoundException, DuplicateRecordException;
	                                                       
	
	//For Getting the list of subject details by checking the semester
	public List<SubjectEntity> findSubjectBySemester(String subjectSemester) throws RecordNotFoundException;
	
	public boolean getSubjectExistById(int subjectId);
	
	
	
	

}