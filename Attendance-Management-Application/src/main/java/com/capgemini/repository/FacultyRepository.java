package com.capgemini.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.entity.FacultyEntity;

@Repository
public interface FacultyRepository extends JpaRepository<FacultyEntity,Integer>{
	
	
	//It will return the list of Faculty details by checking the faculty name & Ignoring case
	List<FacultyEntity> findByfacultyNameIgnoreCaseContains(String facultyName);

}
 