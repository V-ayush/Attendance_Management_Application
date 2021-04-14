package com.capgemini.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Courses")
public class CourseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int courseId;
	
	@Column(name = "course_name")
	private String courseName;

	private String description;
	
	/*
	 * @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy =
	 * "courseId") private List<SubjectEntity> subjectId;
	 * 
	 * @OneToOne(mappedBy = "courseId") private StudentEntity studentId;
	 */

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/*
	 * public List<SubjectEntity> getSubjectId() { return subjectId; }
	 * 
	 * public void setSubjectId(List<SubjectEntity> subjectId) { this.subjectId =
	 * subjectId; }
	 * 
	 * public StudentEntity getStudentId() { return studentId; }
	 * 
	 * public void setStudentId(StudentEntity studentId) { this.studentId =
	 * studentId; }
	 */
	
	@Override
	public String toString() {
		return "CoursesEntity [courseId=" + courseId + ", courseName=" + courseName + ", description=" + description
				+ ",]";
	}

}
