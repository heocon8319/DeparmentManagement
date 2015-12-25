package com.vitech.studentmanagement.dao;

import java.util.List;

import com.vitech.studentmanagement.model.Role;
import com.vitech.studentmanagement.model.Student;

public interface StudentDao {

	public List<Student> find(Role role);
	
	public Student findById(Role role, String maSv);
	
	public boolean update(Role role,  Student student);
	
	public boolean seftUpdate(Role role, Student student);
	
	public boolean add(Role role, Student student);
}
