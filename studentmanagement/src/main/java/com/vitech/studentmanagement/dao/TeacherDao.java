package com.vitech.studentmanagement.dao;

import java.util.List;

import com.vitech.studentmanagement.model.Role;
import com.vitech.studentmanagement.model.Teacher;

public interface TeacherDao {

	public List<Teacher> findAll(Role role);
	
	public boolean seftUpdate(Role role, Teacher teacher);
}
