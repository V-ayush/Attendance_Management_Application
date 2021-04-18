package com.capgemini.service;

import java.util.List;

import com.capgemini.entity.AttendanceEntity;
import com.capgemini.exception.AttendanceIdNotFoundException;
import com.capgemini.exception.RecordNotFoundException;
import com.capgemini.exception.StudentNotFoundException;
import com.capgemini.exception.SubjectNotFoundException;

public interface AttendanceService {
	
	//For Getting the details of all the attendance present in the database
	public List<AttendanceEntity> getAttendance() throws RecordNotFoundException;
		
	//For Updating the details of the Attendance By Attendance ID
	public AttendanceEntity updateAttendanceById(int attendanceId,AttendanceEntity entity)
			throws AttendanceIdNotFoundException;
	
	//For deleting records of Attendance by Attendance ID
	public String deleteById(int attendanceId) throws RecordNotFoundException;
	
	//For Adding the attendance details with respect to Subject Id & Student Id
	public AttendanceEntity addAttendanceWithStudentIdAndSubjectId(AttendanceEntity entity, int studentId, int subjectId) 
			throws StudentNotFoundException, SubjectNotFoundException;
	
	//For Getting attendance according to the Semester
	public List<AttendanceEntity> findAttendanceBySemester(String semester)throws RecordNotFoundException;

	//For Getting the List of Students who are present or absent
	public List<AttendanceEntity> findAttendanceByStatus(String status) throws RecordNotFoundException;
	
	public boolean getAttendanceExistById(int attendanceId);
	
}

