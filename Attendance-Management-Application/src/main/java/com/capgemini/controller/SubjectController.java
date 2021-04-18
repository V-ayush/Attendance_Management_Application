package com.capgemini.controller;

import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.capgemini.entity.SubjectEntity;
import com.capgemini.exception.CourseIdNotFoundException;
import com.capgemini.exception.DuplicateRecordException;
import com.capgemini.exception.FacultyIdNotFoundException;
import com.capgemini.exception.RecordNotFoundException;
import com.capgemini.exception.SubjectNotFoundException;
import com.capgemini.service.SubjectService;

@RestController
@RequestMapping("/Subject")
public class SubjectController {
	
	@Autowired
	SubjectService subjectService;
	
	//Add Subject Details
	@PostMapping(path="/addSubject") 
	public ResponseEntity<SubjectEntity> addSubject(@Valid @RequestBody SubjectEntity entity) 
			throws DuplicateRecordException 
		{
				return new ResponseEntity<SubjectEntity>(subjectService.addSubject(entity),HttpStatus.ACCEPTED);
		}
	
	//Update Subject Details By using Student ID
	@PutMapping(path="/updateSubjectById/{subjectId}")
	public ResponseEntity<SubjectEntity> updateSubjectById(@Valid @PathVariable int subjectId, @Valid @RequestBody SubjectEntity entity)
			throws SubjectNotFoundException
		{
				return new ResponseEntity<SubjectEntity>(subjectService.updateSubjectById(subjectId, entity), HttpStatus.ACCEPTED);
		}
	
	//Retrieve Subject Details By using Subject ID
	@GetMapping(path="/getSubjectById/{subjectId}") 
	public ResponseEntity <SubjectEntity> getSubjectById(@PathVariable int subjectId) 
			throws SubjectNotFoundException
		{
				return new ResponseEntity<SubjectEntity>(subjectService.getSubjectById(subjectId), HttpStatus.FOUND);
		}
	
	//Retrieve All Details of Subjects
	@GetMapping(path="/getAllSubjects")
	public ResponseEntity<List<SubjectEntity>> getAllSubjects() 
			throws RecordNotFoundException
		{ 
				return new ResponseEntity<List<SubjectEntity>>(subjectService.getAllSubjects(), HttpStatus.FOUND);
		}
    
	//Retrieve List of Subjects
	@GetMapping(path="/getSubjectsByName/{subjectName}") 
	public ResponseEntity<List<SubjectEntity>> findSubjectByName(@PathVariable String subjectName)
	         throws RecordNotFoundException
	  	{
		  		return new ResponseEntity<List<SubjectEntity>>(subjectService.findSubjectByName(subjectName),HttpStatus.FOUND);
	    }
	
	//Delete Subject Details By Subject Id
	@DeleteMapping(path="/deleteSubject/{subjectId}")
	public ResponseEntity<String> deleteSubById(@Valid @PathVariable int subjectId) 
			throws RecordNotFoundException
		{
				subjectService.deleteSubById(subjectId);
				return new ResponseEntity<String>("Deleted",HttpStatus.ACCEPTED);
		}
	
	//Add Subject details with respect to Faculty Id & Course Id
	@PostMapping(path="/addSubjectwithFaculty&Course/{facultyId}/{courseId}") 
	public ResponseEntity<SubjectEntity> addSubjectwithFC
	(@Valid @RequestBody SubjectEntity entity, @Valid @PathVariable int facultyId,@Valid @PathVariable int courseId) 
			throws FacultyIdNotFoundException,CourseIdNotFoundException, DuplicateRecordException
		{
				return new ResponseEntity<SubjectEntity>(subjectService.addSubjectwithFC(entity,facultyId,courseId),HttpStatus.CREATED);
		}
	
	//Retrieve Subject details by semester
	@GetMapping(path="/getSubjectsBySemester/{subjectSemester}") 
	public ResponseEntity<List<SubjectEntity>> findSubjectBySemester(String subjectSemester) 
			throws RecordNotFoundException
		{
				return new ResponseEntity<List<SubjectEntity>>(subjectService.findSubjectBySemester(subjectSemester),HttpStatus.FOUND);  
		}
}