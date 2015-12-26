package com.vitech.studentmanagement.service.Impl;

import java.util.List;

import com.vitech.studentmanagement.dao.RegisterSubjectDao;
import com.vitech.studentmanagement.dao.impl.RegisterSubjectDaoImpl;
import com.vitech.studentmanagement.model.RegisterSubject;
import com.vitech.studentmanagement.model.Role;
import com.vitech.studentmanagement.service.RegisterSubjectService;

public class RegisterSubjectServiceImpl implements RegisterSubjectService{

	private RegisterSubjectDao registerSubjectDao = new RegisterSubjectDaoImpl();
	
	public List<RegisterSubject> findAll(Role role) {
		return registerSubjectDao.findAll(role);
	}

}
