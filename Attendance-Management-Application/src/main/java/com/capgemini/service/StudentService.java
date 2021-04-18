package com.capgemini.service;

import java.util.List;

import com.capgemini.entity.StudentEntity;
import com.capgemini.exception.CourseIdNotFoundException;
import com.capgemini.exception.DuplicateRecordException;
import com.capgemini.exception.RecordNotFoundException;
import com.capgemini.exception.StudentNotFoundException;

public interface StudentService {
	
	//For Getting the Student Details by Student Id
	public StudentEntity getStudentById(int studentId) throws StudentNotFoundException;

	//For Getting details of all the Students
	public List<StudentEntity> getStudents() throws RecordNotFoundException;
	
	//For Updating the Student by student id
	public StudentEntity updateStudent(int studentId, StudentEntity entity) throws StudentNotFoundException;

	//For deleting the Student by student id
	public String deleteStudent(int studentId) throws RecordNotFoundException;	
	
	//For Adding the Student with respect to Course Id
	public StudentEntity addStudentwithC(StudentEntity entity, int courseId)throws CourseIdNotFoundException, DuplicateRecordException;
	
	//For Getting the list of Student by checking the first name
	public List<StudentEntity> findStudentByFirstName(String firstName)throws StudentNotFoundException;
	
	//For getting the list of students by checking the FirstName AND last Name
	public List<StudentEntity> findStudentByFirstNameAndLastName(String firstName,String lastName)throws StudentNotFoundException;
	
	public boolean getStudentExistById(int studentId);

}
