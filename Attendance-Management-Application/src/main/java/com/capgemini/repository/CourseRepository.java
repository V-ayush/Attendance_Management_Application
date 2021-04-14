package com.capgemini.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.entity.CourseEntity;

@Repository
public interface CourseRepository extends JpaRepository<CourseEntity,Integer>{

}
