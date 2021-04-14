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

import com.capgemini.entity.CourseEntity;
import com.capgemini.service.CourseService;


@RestController
@RequestMapping("/Course")
public class CourseController {
	
	@Autowired
	CourseService courServices;
	
	@PostMapping(path="/addCourse")
	public ResponseEntity<CourseEntity> addCourse(@RequestBody CourseEntity se)
	{
		CourseEntity se1 = courServices.addCourse(se);
		
		return new ResponseEntity<CourseEntity>(se1,HttpStatus.OK);
	}

	@PutMapping(path="/updateCourse")
	public ResponseEntity<CourseEntity> updateCourse(@RequestBody CourseEntity se)
	{
		CourseEntity se2 = courServices.updateCourse(se);
		
		return new ResponseEntity<CourseEntity>(se2,HttpStatus.OK);
	}
	
	@DeleteMapping(path="/deleteCourse")
	public String deleteCourse(@RequestBody CourseEntity se)
	{
		String s1 = courServices.deleteCourse(se);
		
		return s1;
	}
}
