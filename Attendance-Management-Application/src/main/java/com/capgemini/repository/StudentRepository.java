package com.capgemini.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.entity.StudentEntity;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity,Integer>{

	//This Query will return the list of Student details by checking the first name & ignoring case
	List<StudentEntity> findAllByFirstNameIgnoreCase(String firstName);
	
	//This Query will return the list of Student by checking the first name & last name and by ignoring case
	List<StudentEntity> findAllByFirstNameIgnoreCaseAndLastNameIgnoreCase(String firstName,String lastName);
}