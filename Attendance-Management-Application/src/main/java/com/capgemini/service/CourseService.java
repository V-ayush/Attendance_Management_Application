package com.capgemini.service;

import com.capgemini.entity.CourseEntity;

public interface CourseService {
	
    public CourseEntity addCourse(CourseEntity entity);
	
	public CourseEntity updateCourse(CourseEntity entity);
	
	public String deleteCourse(CourseEntity entity);

}
