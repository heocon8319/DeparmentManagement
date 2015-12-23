package com.vitech.studentmanagement.service;

import java.util.List;

import com.vitech.studentmanagement.model.Role;
import com.vitech.studentmanagement.model.Subject;

public interface SubjectService {

	public List<Subject> find(Role role, int year, int semester);
}
