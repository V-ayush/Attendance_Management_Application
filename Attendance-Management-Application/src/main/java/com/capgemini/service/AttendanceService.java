package com.capgemini.service;

import java.util.List;
import java.util.Optional;

import com.capgemini.entity.AttendanceEntity;

public interface AttendanceService {
	
	public AttendanceEntity addAttendance(AttendanceEntity entity);
	
	public AttendanceEntity updateAttendance(AttendanceEntity entity);
	
	public String deleteAttendance(AttendanceEntity entity);
	
	public List<AttendanceEntity> getAttendance();
	
	public AttendanceEntity getAttendanceById(int attendanceId);
	

	
}

