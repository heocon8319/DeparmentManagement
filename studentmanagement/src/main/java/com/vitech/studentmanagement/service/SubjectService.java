package com.vitech.studentmanagement.service;

import java.util.List;

import com.vitech.studentmanagement.model.Role;
import com.vitech.studentmanagement.model.Subject;
import com.vitech.studentmanagement.model.SubjectOpen;
import com.vitech.studentmanagement.model.SubjectSpeciality;

public interface SubjectService {

	public List<Subject> find(Role role, int year, int semester);

	public List<Subject> findAll(Role role);
	
	public List<SubjectSpeciality> getAll(Role role);
	
	public boolean addSubjectSpeciality(Role role, SubjectSpeciality subjectSpeciality);
	
	public List<SubjectOpen> getSubjectOpen(Role role);
}
