package com.vitech.studentmanagement.service;

import java.util.List;

import com.vitech.studentmanagement.model.Role;
import com.vitech.studentmanagement.model.Schedule;

public interface ScheduleService {

	public List<Schedule> findAll(Role role);
}
