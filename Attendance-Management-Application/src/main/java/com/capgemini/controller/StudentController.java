package com.capgemini.controller;

import java.util.List;

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

import com.capgemini.entity.StudentEntity;
import com.capgemini.service.StudentService;

@RestController
@RequestMapping("/Student")
public class StudentController {
	
	@Autowired
	StudentService studServices;
	
	@PostMapping(path="/addStudent")
	public ResponseEntity<StudentEntity> addStudent(@RequestBody StudentEntity se)
	{
		StudentEntity se1 = studServices.addStudent(se);
		
		return new ResponseEntity<StudentEntity>(se1,HttpStatus.OK);
	}

	@PutMapping(path="/updateStudent")
	public ResponseEntity<StudentEntity> updateStudent(@RequestBody StudentEntity se)
	{
		StudentEntity se2 = studServices.updateStudent(se);
		
		return new ResponseEntity<StudentEntity>(se2,HttpStatus.OK);
	}
	
	@DeleteMapping(path="/deleteStudent")
	public String deleteStudent(@RequestBody StudentEntity se)
	{
		String s1 = studServices.deleteStudent(se);
		
		return s1;
	}
	
	@GetMapping("/byfirstname/{firstName}")
	public ResponseEntity<List<StudentEntity>> getAllStudentByFirstName(@PathVariable String firstName)
	{
		return new ResponseEntity<List<StudentEntity>>(studServices.getAllStudentByFirstName(firstName),HttpStatus.OK);
	}
}
