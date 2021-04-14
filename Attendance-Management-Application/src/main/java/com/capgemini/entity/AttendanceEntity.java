package com.capgemini.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Attendences")
public class AttendanceEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int attendanceId;

	private String semester;
	
	//private Date date;
	
	private String status;
	
	public int getAttendanceId() {
		return attendanceId;
	}

	public void setAttendanceId(int attendanceId) {
		this.attendanceId = attendanceId;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	/*
	 * public Date getDate() { return date; }
	 * 
	 * public void setDate(Date date) { this.date = date; }
	 */

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	/*
	 * @ManyToOne(fetch = FetchType.LAZY)
	 * 
	 * @JoinColumn(name = "Attendance_Subject") private SubjectEntity subjectId;
	 * 
	 * @ManyToOne(fetch = FetchType.LAZY)
	 * 
	 * @Column(name = "student_roll_no") private long studentRollNo;
	 */
	
	


}