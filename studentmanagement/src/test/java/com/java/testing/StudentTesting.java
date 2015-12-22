package com.java.testing;

import java.util.List;

import com.vitech.studentmanagement.dao.StudentDao;
import com.vitech.studentmanagement.dao.impl.StudentDaoImpl;
import com.vitech.studentmanagement.model.Role;
import com.vitech.studentmanagement.model.Student;

public class StudentTesting {

	public static void main(String[] args){
		StudentDao studentD = new StudentDaoImpl();
		Role role = new Role();
		role.setUserName("SV01");
		role.setPassword("1234");
		
//		List<Student> students = studentD.find(role);
//		for(Student st: students){
//			System.out.println(st.getMaSv());
//			System.out.println(st.getTenSv());
//		}
		
		Student st = studentD.findById(role, "SV01");
		System.out.println(st.getMaSv());
		System.out.println(st.getTenSv());
	}
}
