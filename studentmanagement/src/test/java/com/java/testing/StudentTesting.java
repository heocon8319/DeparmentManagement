package com.java.testing;

import java.util.List;

import com.vitech.studentmanagement.dao.SpecialityDao;
import com.vitech.studentmanagement.dao.StudentDao;
import com.vitech.studentmanagement.dao.impl.SpecialityDaoImpl;
import com.vitech.studentmanagement.dao.impl.StudentDaoImpl;
import com.vitech.studentmanagement.model.Role;
import com.vitech.studentmanagement.model.Speciality;
import com.vitech.studentmanagement.model.Student;

public class StudentTesting {

	public static void main(String[] args){
		StudentDao studentD = new StudentDaoImpl();
		Role role = new Role();
		role.setUserName("NV07");
		role.setPassword("1234");
		
//		List<Student> students = studentD.find(role);
//		for(Student st: students){
//			System.out.println(st.getMaSv());
//			System.out.println(st.getTenSv());
//		}
		
//		Student st = new Student();
//		st.setDiaChi("123 Hai Ba Trung, Q1");
//		st.setGioiTinh("Nam");
//		st.setMaNganh("MMT");
//		st.setMaSv("SV12");
//		st.setNgaySinh("1990-04-14");
//		st.setTenSv("Pham Thi Le");
//		st.setSoDienThoai("0122484822");
//		
//		boolean rs = studentD.add(role, st);
//		System.out.println(rs);
		
		SpecialityDao spd = new SpecialityDaoImpl();
		List<Speciality> spls = spd.findAll(role);
		for(Speciality sp: spls){
			System.out.println(sp.getMaNganh());
			System.out.println(sp.getTenNganh());
		}
	}
}
