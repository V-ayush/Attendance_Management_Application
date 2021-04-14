package com.capgemini.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.entity.FacultyEntity;

@Repository
public interface FacultyRepository extends JpaRepository<FacultyEntity,Integer>{

}
