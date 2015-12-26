package com.vitech.studentmanagement.service;

import java.util.List;

import com.vitech.studentmanagement.model.RegisterSubject;
import com.vitech.studentmanagement.model.Role;

public interface RegisterSubjectService {

	public List<RegisterSubject> findAll(Role role); 
}
