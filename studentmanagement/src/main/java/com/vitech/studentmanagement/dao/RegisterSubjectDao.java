package com.vitech.studentmanagement.dao;

import java.util.List;

import com.vitech.studentmanagement.model.RegisterSubject;
import com.vitech.studentmanagement.model.Role;

public interface RegisterSubjectDao {

	public List<RegisterSubject> findAll(Role role); 
}
