package com.capgemini.service;

import com.capgemini.entity.SubjectEntity;

public interface SubjectService {
	
	public SubjectEntity addSubject(SubjectEntity entity);
	
	public SubjectEntity updateSubject(SubjectEntity entity);
	
	public String deleteSubject(SubjectEntity entity);

}
