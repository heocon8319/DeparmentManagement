package com.vitech.studentmanagement.service;

import java.util.List;

import com.vitech.studentmanagement.model.Role;
import com.vitech.studentmanagement.model.Student;

public interface StudentService {

	public List<Student> find(Role role);
	
	public Student findById(Role role, String maSv);
	
	public boolean update(Role role, Student student);
}
