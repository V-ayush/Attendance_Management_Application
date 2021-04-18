package com.capgemini.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.entity.CourseEntity;

@Repository
public interface CourseRepository extends JpaRepository<CourseEntity,Integer>{

    
	//It will return the list of details of Course by checking the Course Name by Ignoring Case (AUTO GENERATED QUERY BY JPA) 
	List<CourseEntity> findByCourseNameIgnoreCaseContains(String courseName);
}
