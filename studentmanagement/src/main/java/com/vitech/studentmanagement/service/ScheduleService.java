package com.vitech.studentmanagement.service;

import java.util.List;

import com.vitech.studentmanagement.model.Role;
import com.vitech.studentmanagement.model.Schedule;

public interface ScheduleService {

	public List<Schedule> findAll(Role role);
	
	public boolean add(Role role, Schedule schedule);
	
	public Schedule findById(Role role, String subjectCode, String employeeCode);
	
	public boolean update(Role role, Schedule schedule);
}
