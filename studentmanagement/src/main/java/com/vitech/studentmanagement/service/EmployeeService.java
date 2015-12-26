package com.vitech.studentmanagement.service;

import java.util.List;

import com.vitech.studentmanagement.model.Employee;
import com.vitech.studentmanagement.model.Role;

public interface EmployeeService {

	public List<Employee> findAll(Role role);
}
