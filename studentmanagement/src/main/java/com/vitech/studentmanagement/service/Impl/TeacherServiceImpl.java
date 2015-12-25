package com.vitech.studentmanagement.service.Impl;

import java.util.List;

import com.vitech.studentmanagement.dao.TeacherDao;
import com.vitech.studentmanagement.dao.impl.TeacherDaoImpl;
import com.vitech.studentmanagement.model.Role;
import com.vitech.studentmanagement.model.Teacher;
import com.vitech.studentmanagement.service.TeacherService;

public class TeacherServiceImpl implements TeacherService{

	private TeacherDao teacherDao = new TeacherDaoImpl();
	
	public List<Teacher> findAll(Role role) {
		return teacherDao.findAll(role);
	}

}
