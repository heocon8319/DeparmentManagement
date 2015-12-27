package com.java.testing;

import java.util.List;

import com.vitech.studentmanagement.dao.ScheduleDao;
import com.vitech.studentmanagement.dao.TeacherDao;
import com.vitech.studentmanagement.dao.impl.ScheduleDaoImpl;
import com.vitech.studentmanagement.dao.impl.TeacherDaoImpl;
import com.vitech.studentmanagement.model.Role;
import com.vitech.studentmanagement.model.Schedule;
import com.vitech.studentmanagement.model.Teacher;

public class TeacherTesting {

	static TeacherDao teachDao = new TeacherDaoImpl();
	static ScheduleDao scheduleDao = new ScheduleDaoImpl(); 
	
	public static void main(String[] agrs) {

		Role role = new Role();
		role.setUserName("nv04");
		role.setPassword("1234");
		
		Schedule schedule = new Schedule();
		schedule.setMaHK("K2016_1");
		schedule.setMaMH("MH01");
		schedule.setMaNV("NV22");
		schedule.setVaiTro("GVi");
		
		boolean rs = scheduleDao.add(role, schedule);
		System.out.println(rs);

//		List<Teacher> teachers = teachDao.findAll(role);
//		for (Teacher s : teachers) {
//			System.out.println(s.getTenNv());
//			System.out.println(s.getNamSinh());
//		}
	}
}
