package com.capgemini.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.entity.CourseEntity;
import com.capgemini.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	CourseRepository crepo;

	@Override
	public CourseEntity addCourse(CourseEntity entity) {
		CourseEntity ce = (CourseEntity) crepo.save(entity);		
		return ce;
	}

	@Override
	public CourseEntity updateCourse(CourseEntity entity) {
		int id = entity.getCourseId();
		CourseEntity ce = (CourseEntity) crepo.findById(id).orElse(null);
		ce.setCourseName(entity.getCourseName());
		ce.setDescription(entity.getDescription());
		crepo.save(ce);
		return ce;
	}

	@Override
	public String deleteCourse(CourseEntity entity) {
		crepo.delete(entity);
	    return "Deleted";
	}


	
	
	
	

}
