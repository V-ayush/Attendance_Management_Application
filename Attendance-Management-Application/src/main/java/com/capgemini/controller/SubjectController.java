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

import com.capgemini.entity.SubjectEntity;
import com.capgemini.service.SubjectService;

@RestController
@RequestMapping("/Subject")
public class SubjectController {
	
	@Autowired
	SubjectService subServices;
	
	@PostMapping(path="/addSubject")
	public ResponseEntity<SubjectEntity> addSubject(@RequestBody SubjectEntity se)
	{
		SubjectEntity se1 = subServices.addSubject(se);
		
		return new ResponseEntity<SubjectEntity>(se1,HttpStatus.OK);
	}

	@PutMapping(path="/updateSubject")
	public ResponseEntity<SubjectEntity> updateSubject(@RequestBody SubjectEntity se)
	{
		SubjectEntity se2 = subServices.updateSubject(se);
		
		return new ResponseEntity<SubjectEntity>(se2,HttpStatus.OK);
	}
	
	@DeleteMapping(path="/deleteSubject")
	public String deleteSubject(@RequestBody SubjectEntity se)
	{
		String s1 = subServices.deleteSubject(se);
		
		return s1;
	}
}
