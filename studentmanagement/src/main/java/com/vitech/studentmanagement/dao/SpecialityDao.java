package com.vitech.studentmanagement.dao;

import java.util.List;

import com.vitech.studentmanagement.model.Speciality;
import com.vitech.studentmanagement.model.Role;

public interface SpecialityDao {
	
	public List<Speciality> findAll(Role role);
}
