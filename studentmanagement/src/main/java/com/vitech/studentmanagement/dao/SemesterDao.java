package com.vitech.studentmanagement.dao;

import java.util.List;

import com.vitech.studentmanagement.model.Role;
import com.vitech.studentmanagement.model.Semester;

public interface SemesterDao {

	public List<Semester> findAll(Role role);
}
