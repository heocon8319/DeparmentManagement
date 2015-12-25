package com.vitech.studentmanagement.service;

import java.util.List;

import com.vitech.studentmanagement.model.Role;
import com.vitech.studentmanagement.model.Teacher;

public interface TeacherService {

	public List<Teacher> findAll(Role role);
}
