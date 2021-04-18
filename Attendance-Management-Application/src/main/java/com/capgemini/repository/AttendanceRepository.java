package com.capgemini.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.capgemini.entity.AttendanceEntity;

@Repository
public interface AttendanceRepository extends JpaRepository<AttendanceEntity,Integer>{

 
    //It will return the list of details Attendance by checking the status(absent/present)
    List<AttendanceEntity> findByStatusIgnoreCase(String status);
	
    //It will return the list of details Attendance by checking the semester
	List<AttendanceEntity> findBySemester(String semester);
}
