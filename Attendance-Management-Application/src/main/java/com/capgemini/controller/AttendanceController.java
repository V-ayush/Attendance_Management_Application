package com.capgemini.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.entity.AttendanceEntity;
import com.capgemini.service.AttendanceService;

@RestController
@RequestMapping("/Attendance")
public class AttendanceController {

	@Autowired
	AttendanceService attService;
	
	@PostMapping(path="/addAttendance")
	public ResponseEntity<AttendanceEntity> addAttend(@RequestBody AttendanceEntity ae)
	{
		return new ResponseEntity<AttendanceEntity>(attService.addAttendance(ae),HttpStatus.OK);
	}
	
	@PutMapping(path="/updateAttendance")
	public ResponseEntity<AttendanceEntity> updateAttend(@RequestBody AttendanceEntity ae)
	{
		return new ResponseEntity<AttendanceEntity>(attService.updateAttendance(ae),HttpStatus.OK);
	}
	
	@DeleteMapping(path="/deleteAttendance")
	public String deleteAttend(@RequestBody AttendanceEntity ae)
	{
		return  attService.deleteAttendance(ae);
	}
	
	@GetMapping(path="/getAttendance")
	public ResponseEntity<List<AttendanceEntity>> getAttendance()
	{
		return new ResponseEntity<List<AttendanceEntity>>(attService.getAttendance(),HttpStatus.OK);
	}
	
	@GetMapping(path="/getAttendance/{attendanceId}")
	public ResponseEntity<AttendanceEntity> getAttendanceById(@PathVariable int attendanceId)
	{
		return new ResponseEntity<AttendanceEntity>(attService.getAttendanceById(attendanceId),HttpStatus.OK);
	}
}
