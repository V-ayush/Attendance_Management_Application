package com.capgemini.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.capgemini.entity.CourseEntity;
import com.capgemini.entity.FacultyEntity;
import com.capgemini.entity.SubjectEntity;
import com.capgemini.exception.CourseIdNotFoundException;
import com.capgemini.exception.DuplicateRecordException;
import com.capgemini.exception.FacultyIdNotFoundException;
import com.capgemini.exception.RecordNotFoundException;
import com.capgemini.exception.SubjectNotFoundException;
import com.capgemini.repository.CourseRepository;
import com.capgemini.repository.FacultyRepository;
import com.capgemini.repository.SubjectRepository;

@Service
public class SubjectServiceImpl implements SubjectService{
	
	@Autowired
	SubjectRepository subjectRepository;
	
	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	FacultyRepository facultyRepository;
	
	@Autowired
	FacultyService facultyService;
	
	@Autowired
	CourseService courseService;
	
	
	//For Adding the Subject Record
	@Override
	public SubjectEntity addSubject(SubjectEntity entity) 
			throws DuplicateRecordException
		{
			List<SubjectEntity> sub=subjectRepository.findAll();
			for(SubjectEntity subjectentity : sub)
				{
					if(subjectentity.getSubjectName().equalsIgnoreCase(entity.getSubjectName()))
						{
							throw new DuplicateRecordException("The name of Subject is already exist......Provide different SubjectName");
						}
		}
			SubjectEntity subjectentity = (SubjectEntity) subjectRepository.save(entity);		
			return subjectentity;
		}

	//For Deleting the Subject Entity by using subject Id
	@Override 
	public String deleteSubById(int subjectId) 
		{
			subjectRepository.findById(subjectId).orElse(null); 
			subjectRepository.deleteById(subjectId);
			return "Deleted"; 
		}
	 
	//For getting the subject details by subject Id
	@Override
	public SubjectEntity getSubjectById(int subjectId) 
			throws SubjectNotFoundException 
		{
			Supplier<SubjectNotFoundException> supplier=()->new SubjectNotFoundException("Subject not found with this id");
			return subjectRepository.findById(subjectId).orElseThrow(supplier);
		}
	
	//For Getting the list of the details of all the subjects
	@Override
	public List<SubjectEntity> getAllSubjects() 
			throws RecordNotFoundException 
		{
			List<SubjectEntity> subjectentity = new ArrayList<SubjectEntity>();
			subjectentity = subjectRepository.findAll();		
			if(subjectentity.isEmpty())
					throw new RecordNotFoundException("Record Not Found In The Database");
			return subjectentity;
		}

	//For updating the subject details by using subject Id
	@Override
	public SubjectEntity updateSubjectById(int subjectId, SubjectEntity entity) 
			throws SubjectNotFoundException
		{
			Supplier<SubjectNotFoundException> supplier=()->new SubjectNotFoundException("Given Subject id is not present in database");
			SubjectEntity subjectDetails = subjectRepository.findById(subjectId).orElseThrow(supplier);
			subjectDetails.setSubjectName(entity.getSubjectName());
			subjectDetails.setSubjectSemester(entity.getSubjectSemester());
			subjectDetails.setDescription(entity.getDescription());
			subjectRepository.save(subjectDetails);
			return subjectDetails;
		}

	//For Getting the list of Subject details by checking the Name of the subject
	@Override
	public List<SubjectEntity> findSubjectByName(String subjectName) 
			throws RecordNotFoundException
		{
			List<SubjectEntity> subjectList = subjectRepository.findBysubjectNameIgnoreCaseContains(subjectName);
			if(subjectList.isEmpty())
					throw new RecordNotFoundException("Record Not Found In The Database");
			return subjectList;
		}

	//For Adding the Subject with respect to Faculty Id & Course Id
	@Override
	public SubjectEntity addSubjectwithFC(SubjectEntity entity, int facultyId, int courseId) 
			throws FacultyIdNotFoundException, CourseIdNotFoundException, DuplicateRecordException 
		{
			List<SubjectEntity> subjectList = new ArrayList<>();
			List<SubjectEntity> subjectList1 = subjectRepository.findAll();
			for(SubjectEntity subjectEntity:subjectList1)
				{
					if(subjectEntity.getSubjectName().equalsIgnoreCase(entity.getSubjectName()))
						{
							throw new DuplicateRecordException("Subject Already Present! Please Provide different Subject Name");
						}
				}
			FacultyEntity faculty;
			CourseEntity course;
			Supplier<FacultyIdNotFoundException> supplier1 = ()-> new FacultyIdNotFoundException("Faculty with given Id is not availabe");
			faculty = facultyRepository.findById(facultyId).orElseThrow(supplier1);
			Supplier<CourseIdNotFoundException> supplier2 = ()-> new CourseIdNotFoundException("Course with given Id is not availabe");
			course = courseRepository.findById(courseId).orElseThrow(supplier2);
			entity.setCourse(course);
			entity.setFacultyentity(faculty);
			subjectRepository.save(entity);
			subjectList.add(entity);
			faculty.setSubjectList(subjectList);
			course.setSubjectList(subjectList);
			return entity;
		}
	
	//For Getting the list of subject details by checking the semester
	@Override 
	public List<SubjectEntity> findSubjectBySemester(String subjectSemester) 
			throws RecordNotFoundException
	  	{ 
			List<SubjectEntity> subjectList = subjectRepository.findBysubjectSemester(subjectSemester);
			if(subjectList.isEmpty())
					throw new RecordNotFoundException("Data Not Found In The Database");
			return subjectList;
	  
	  	}
	
	@Override
	public boolean getSubjectExistById(int subjectId)
		{
			return subjectRepository.existsById(subjectId);
		}


}
