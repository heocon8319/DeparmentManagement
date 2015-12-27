package com.vitech.studentmanagement.service.Impl;

import java.util.List;

import com.vitech.studentmanagement.dao.StudentDao;
import com.vitech.studentmanagement.dao.impl.StudentDaoImpl;
import com.vitech.studentmanagement.model.Role;
import com.vitech.studentmanagement.model.Student;
import com.vitech.studentmanagement.service.StudentService;
import com.vitech.studentmanagement.utility.Constant;

public class StudentServiceImpl implements StudentService{

	private StudentDao studentDao = new StudentDaoImpl();
	
	public List<Student> find(Role role) {
		return studentDao.find(role);
	}

	public Student findById(Role role, String maSv) {
		return studentDao.findById(role, maSv);
	}

	public boolean update(Role role, Student student) {
		boolean result = false;
		if(role.checkRole().equals(Constant.DBASV)){
			result = studentDao.update(role, student);
		}else{
			result = studentDao.seftUpdate(role, student);
		}
		return result;
	}

	public boolean add(Role role, Student student) {
		return studentDao.add(role, student);
	}
}
