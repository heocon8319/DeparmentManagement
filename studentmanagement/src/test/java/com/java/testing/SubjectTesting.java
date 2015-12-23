package com.java.testing;

import java.util.List;

import com.vitech.studentmanagement.dao.SubjectDao;
import com.vitech.studentmanagement.dao.impl.SubjectDaoImpl;
import com.vitech.studentmanagement.model.Role;
import com.vitech.studentmanagement.model.Subject;

public class SubjectTesting {

	static SubjectDao subDao = new SubjectDaoImpl();
	public static void main(String[] agrs){
		
		Role role = new Role();
		role.setUserName("SV01");
		role.setPassword("1234");
		
		List<Subject> subs = subDao.find(role,2015,2);
		for(Subject s: subs){
			System.out.println(s.getTenMH());
		}
	}
}
