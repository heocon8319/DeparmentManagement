package com.vitech.studentmanagement.service;

import java.util.List;

import com.vitech.studentmanagement.model.Role;
import com.vitech.studentmanagement.model.Semester;

public interface SemesterService {
	public List<Semester> findAll(Role role);
}
