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

import com.capgemini.entity.FacultyEntity;
import com.capgemini.exception.FacultyIdNotFoundException;
import com.capgemini.exception.RecordNotFoundException;
import com.capgemini.service.FacultyService;

@RestController
@RequestMapping("/Faculty")
public class FacultyController {
	
	@Autowired
	FacultyService facultyService;
	
	//Add Faculty Details
	@PostMapping(path="/addFaculty")
	public ResponseEntity<FacultyEntity> addFaculty(@Valid @RequestBody FacultyEntity entity)
		{
				return new ResponseEntity<FacultyEntity>(facultyService.addFaculty(entity),HttpStatus.CREATED);
		}
	
	//Retrieve Faculty using Faculty Id
	@GetMapping(path="/getFacultyById/{facultyId}")
	public ResponseEntity<FacultyEntity> getFacultyById(@Valid @PathVariable int facultyId) 
			throws FacultyIdNotFoundException
		{
				return new ResponseEntity<FacultyEntity>(facultyService.getFacultyById(facultyId), HttpStatus.FOUND);
		}
	
	//Delete Faculty using Faculty Id
	@DeleteMapping(path="/deleteFacultyById/{facultyId}")
	public ResponseEntity<String> deleteFacultyById(@Valid @PathVariable int facultyId) 
			throws RecordNotFoundException
		{
				facultyService.deleteFacultyById(facultyId);
				return new ResponseEntity<String>("Deleted by Id from Database", HttpStatus.ACCEPTED);
		}
	
	//Retrieve All Faculties details
	@GetMapping(path="/getAllFaculties")
	public ResponseEntity<List<FacultyEntity>> getAllFaculty() 
			throws RecordNotFoundException
		{
				return new ResponseEntity<List<FacultyEntity>>(facultyService.getAllFaculty(), HttpStatus.FOUND);
		}
	
	//Update faculty details using faculty Id
	@PutMapping(path="/updateFacultyById/{facultyId}")
	public ResponseEntity<FacultyEntity> updateFacultyById(@Valid @PathVariable int facultyId, @Valid @RequestBody FacultyEntity entity) 
			throws FacultyIdNotFoundException
		{
				return new ResponseEntity<FacultyEntity>(facultyService.updateFacultyById(facultyId, entity), HttpStatus.ACCEPTED);
		}
	
	//Retrieve faculty details by faculty name 
    @GetMapping(path="/getFacultyByName/{facultyName}") 
    public ResponseEntity<List<FacultyEntity>> findFacultyByName(@PathVariable String facultyName) 
    		 throws RecordNotFoundException
      	{ 
				return new ResponseEntity<List<FacultyEntity>>(facultyService.findByfacultyName(facultyName),HttpStatus.FOUND);
      	}
}
