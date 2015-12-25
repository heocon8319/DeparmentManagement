package com.vitech.studentmanagement.service.Impl;

import java.util.List;

import com.vitech.studentmanagement.dao.SpecialityDao;
import com.vitech.studentmanagement.dao.impl.SpecialityDaoImpl;
import com.vitech.studentmanagement.model.Role;
import com.vitech.studentmanagement.model.Speciality;
import com.vitech.studentmanagement.service.SpecialityService;

public class SpecialityServiceImpl implements SpecialityService{

	private SpecialityDao specialityDao = new SpecialityDaoImpl();
	
	public List<Speciality> findAll(Role role) {
		return specialityDao.findAll(role);
	}

	
}
