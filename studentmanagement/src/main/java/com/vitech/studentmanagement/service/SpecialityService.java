package com.vitech.studentmanagement.service;

import java.util.List;

import com.vitech.studentmanagement.model.Role;
import com.vitech.studentmanagement.model.Speciality;

public interface SpecialityService {
	public List<Speciality> findAll(Role role);
}
