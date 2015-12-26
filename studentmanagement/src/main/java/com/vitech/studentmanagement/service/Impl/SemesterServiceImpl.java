package com.vitech.studentmanagement.service.Impl;

import java.util.List;

import com.vitech.studentmanagement.dao.SemesterDao;
import com.vitech.studentmanagement.dao.impl.SemesterDaoImpl;
import com.vitech.studentmanagement.model.Role;
import com.vitech.studentmanagement.model.Semester;
import com.vitech.studentmanagement.service.SemesterService;

public class SemesterServiceImpl implements SemesterService{

	private SemesterDao semesterDao = new SemesterDaoImpl();
	
	public List<Semester> findAll(Role role) {
		return semesterDao.findAll(role);
	}

}
