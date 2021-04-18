package com.capgemini.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.entity.CourseEntity;
import com.capgemini.entity.StudentEntity;
import com.capgemini.exception.CourseIdNotFoundException;
import com.capgemini.exception.DuplicateRecordException;
import com.capgemini.exception.RecordNotFoundException;
import com.capgemini.exception.StudentNotFoundException;
import com.capgemini.repository.CourseRepository;
import com.capgemini.repository.StudentRepository;
@Service
public class StudentServiceImpl implements StudentService{

	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	CourseService courseService;
	

	//For Getting the Student Details by Student Id
	@Override
	public StudentEntity getStudentById(int studentId) 
			throws StudentNotFoundException
		{
			Supplier<StudentNotFoundException> supplier=()->new StudentNotFoundException("no Student found with this id");
			StudentEntity entity=studentRepository.findById(studentId).orElseThrow(supplier);
			return entity;
		}

	//For Getting details of all the Students
	@Override
	public List<StudentEntity> getStudents() 
			throws RecordNotFoundException
		{
			List<StudentEntity> studentList = studentRepository.findAll();
			if(studentList.isEmpty())
					throw new RecordNotFoundException("RecordNot Found In The Database");
			return studentList;
		}
		
	//For Updating the Student by student id
	@Override
	public StudentEntity updateStudent(int studentId, StudentEntity entity) 
			throws StudentNotFoundException
		{
			Supplier<StudentNotFoundException> supplier=()->new StudentNotFoundException("No such Student Found");
			StudentEntity studentList = studentRepository.findById(studentId).orElseThrow(supplier);
			studentList.setFirstName(entity.getFirstName());
			studentList.setLastName(entity.getLastName());
			studentList.setDateOfBirth(entity.getDateOfBirth());
			studentList.setEmailId(entity.getEmailId());
			studentList.setFatherEmailId(entity.getFatherEmailId());
			studentList.setFatherMobileNumber(entity.getFatherMobileNumber());
			studentList.setGender(entity.getGender());
			studentList.setMobileNumber(entity.getMobileNumber());
			studentList.setSemester(entity.getSemester());
			studentList.setAttendanceList(entity.getAttendanceList());
			studentList.setCourse(entity.getCourse());
			//studentList.setFaculty(entity.getFaculty());
			return studentRepository.save(studentList);
		}

	//For deleting the Student by student id
	@Override
	public String deleteStudent(int studentId) 
			throws RecordNotFoundException
		{
			Supplier<RecordNotFoundException> supplier=()->new RecordNotFoundException("no Student_id was found");
			StudentEntity studentEntity=studentRepository.findById(studentId).orElseThrow(supplier);
			studentRepository.delete(studentEntity); 
			return "deleted successfully";
		}

	//For Adding the Student with respect to Course Id
	@Override
	public StudentEntity addStudentwithC(StudentEntity entity, int courseId) 
			throws CourseIdNotFoundException, DuplicateRecordException 
		{
			CourseEntity course;
			List<StudentEntity> studentList = studentRepository.findAll();
			for(StudentEntity studentEntity:studentList)
				{
					if(studentEntity.getEmailId().equalsIgnoreCase(entity.getEmailId()))
						{
							throw new DuplicateRecordException("Student Already Present! Please Provide different Student Name");
						}
				}
			List<StudentEntity> entities = new ArrayList<>();
			Supplier<CourseIdNotFoundException> supplier = ()-> new CourseIdNotFoundException("Course with given Id is not availabe");
			course = courseRepository.findById(courseId).orElseThrow(supplier);
			entity.setCourse(course);
			studentRepository.save(entity);
			entities.add(entity);
			course.setStudentList(entities);
			return entity;
		}

	//For Getting the list of Student by checking the first name
	@Override
	public List<StudentEntity> findStudentByFirstName(String firstName) 
			throws StudentNotFoundException 
		{
			List<StudentEntity> entities = new ArrayList<>();
			entities = studentRepository.findAllByFirstNameIgnoreCase(firstName);
			if(entities.isEmpty())
					throw new StudentNotFoundException("Given First Name is Not Available");
			return entities;
		}

	//For getting the list of students by checking the FirstName AND last Name
	@Override
	public List<StudentEntity> findStudentByFirstNameAndLastName(String firstName, String lastName)
			throws StudentNotFoundException 
		{
			List<StudentEntity> entities = new ArrayList<>();
			entities = studentRepository.findAllByFirstNameIgnoreCaseAndLastNameIgnoreCase(firstName, lastName);
			if(entities.isEmpty())
					throw new StudentNotFoundException("Given First Name & Last Name is Not Available");
			return entities;
		}
	
	@Override
	public boolean getStudentExistById(int studentId) 
		{
			return studentRepository.existsById(studentId);
		}

}
