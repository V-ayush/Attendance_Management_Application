package com.capgemini.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.entity.FacultyEntity;
import com.capgemini.service.FacultyService;

@RestController
@RequestMapping("/Faculty")
public class FacultyController {
	
	@Autowired
	FacultyService faclServices;
	
	@PostMapping(path="/addFaculty")
	public ResponseEntity<FacultyEntity> addFaculty(@RequestBody FacultyEntity se)
	{
		FacultyEntity se1 = faclServices.addFaculty(se);
		
		return new ResponseEntity<FacultyEntity>(se1,HttpStatus.OK);
	}

	@PutMapping(path="/updateFaculty")
	public ResponseEntity<FacultyEntity> updateFaculty(@RequestBody FacultyEntity se)
	{
		FacultyEntity se2 = faclServices.updateFaculty(se);
		
		return new ResponseEntity<FacultyEntity>(se2,HttpStatus.OK);
	}
	
	@DeleteMapping(path="/deleteFaculty")
	public String deleteFaculty(@RequestBody FacultyEntity se)
	{
		String s1 = faclServices.deleteFaculty(se);
		
		return s1;
	}
}
