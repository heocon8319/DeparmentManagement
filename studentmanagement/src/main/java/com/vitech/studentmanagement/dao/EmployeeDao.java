package com.vitech.studentmanagement.dao;

import java.util.List;

import com.vitech.studentmanagement.model.Employee;
import com.vitech.studentmanagement.model.Role;

public interface EmployeeDao {

	public List<Employee> findAll(Role role);
}
