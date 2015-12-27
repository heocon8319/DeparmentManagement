package com.vitech.studentmanagement.service.Impl;

import java.util.List;

import com.vitech.studentmanagement.dao.ScheduleDao;
import com.vitech.studentmanagement.dao.impl.ScheduleDaoImpl;
import com.vitech.studentmanagement.model.Role;
import com.vitech.studentmanagement.model.Schedule;
import com.vitech.studentmanagement.service.ScheduleService;

public class ScheduleServiceImpl implements ScheduleService{

	private ScheduleDao scheduleDao = new ScheduleDaoImpl();
	public List<Schedule> findAll(Role role) {
		return scheduleDao.findAll(role);
	}
	public boolean add(Role role, Schedule schedule) {
		return scheduleDao.add(role, schedule);
	}
	public Schedule findById(Role role, String subjectCode, String employeeCode) {
		return scheduleDao.findById(role, subjectCode, employeeCode);
	}
	public boolean update(Role role, Schedule schedule) {
		return scheduleDao.update(role, schedule);
	}

}
