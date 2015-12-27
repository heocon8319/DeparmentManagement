package com.vitech.studentmanagement.dao;

import java.util.List;

import com.vitech.studentmanagement.model.Role;
import com.vitech.studentmanagement.model.Subject;
import com.vitech.studentmanagement.model.SubjectSpeciality;

public interface SubjectDao {

	public List<Subject> find(Role role, int year, int semester);
	
	public List<Subject> findAll(Role role);
	
	public List<SubjectSpeciality> getAll(Role role);
}
