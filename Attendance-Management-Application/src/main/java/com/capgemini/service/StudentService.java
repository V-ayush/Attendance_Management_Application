package com.capgemini.service;

import java.util.List;

import com.capgemini.entity.StudentEntity;

public interface StudentService {
	
	public StudentEntity addStudent(StudentEntity entity);
	
	public StudentEntity updateStudent(StudentEntity entity);
	
	public String deleteStudent(StudentEntity entity);
	
	List<StudentEntity> getAllStudentByFirstName(String firstName);
	

	
	
	
	
	

}
