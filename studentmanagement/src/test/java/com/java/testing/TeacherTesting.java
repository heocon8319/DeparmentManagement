package com.java.testing;

import java.util.List;

import com.vitech.studentmanagement.dao.TeacherDao;
import com.vitech.studentmanagement.dao.impl.TeacherDaoImpl;
import com.vitech.studentmanagement.model.Role;
import com.vitech.studentmanagement.model.Teacher;

public class TeacherTesting {

	static TeacherDao teachDao = new TeacherDaoImpl();
	
	public static void main(String[] agrs) {

		Role role = new Role();
		role.setUserName("nv06");
		role.setPassword("1234");

		List<Teacher> teachers = teachDao.findAll(role);
		for (Teacher s : teachers) {
			System.out.println(s.getTenNv());
			System.out.println(s.getNamSinh());
		}
	}

}
