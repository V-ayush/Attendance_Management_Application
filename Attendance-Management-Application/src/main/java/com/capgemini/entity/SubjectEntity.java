package com.capgemini.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Subjects")
public class SubjectEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int subjectId;
	
	@Column(name="subject_name")
	private String subjectName;
	
	private int subject_semester;
	
	private String description;

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public int getSubject_semester() {
		return subject_semester;
	}

	public void setSubject_semester(int subject_semester) {
		this.subject_semester = subject_semester;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "SubjectEntity [subjectId=" + subjectId + ", subjectName=" + subjectName + ", semester=" + subject_semester
				+ ", description=" + description + "]";
	}

	
	
}
