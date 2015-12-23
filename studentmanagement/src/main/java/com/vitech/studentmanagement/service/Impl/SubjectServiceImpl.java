package com.vitech.studentmanagement.service.Impl;

import java.util.List;

import com.vitech.studentmanagement.dao.SubjectDao;
import com.vitech.studentmanagement.dao.impl.SubjectDaoImpl;
import com.vitech.studentmanagement.model.Role;
import com.vitech.studentmanagement.model.Subject;
import com.vitech.studentmanagement.service.SubjectService;

public class SubjectServiceImpl implements SubjectService {

	private SubjectDao subjectDao = new SubjectDaoImpl();

	public List<Subject> find(Role role, int year, int semester) {
		return subjectDao.find(role, year, semester);
	}

}
