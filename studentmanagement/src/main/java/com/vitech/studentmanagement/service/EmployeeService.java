package com.vitech.studentmanagement.service;

import java.util.List;

import com.vitech.studentmanagement.model.Employee;
import com.vitech.studentmanagement.model.Role;

public interface EmployeeService {

	public List<Employee> findAll(Role role);

	public boolean add(Role role, Employee employee);
	
	public Employee find(Role role, String maNV);
	
	public boolean update(Role role, Employee employee);
	
	public boolean seftUpdate(Role role, Employee employee);
}
