package com.vitech.studentmanagement.service.Impl;

import java.util.List;

import com.vitech.studentmanagement.dao.EmployeeDao;
import com.vitech.studentmanagement.dao.impl.EmployeeDaoImpl;
import com.vitech.studentmanagement.model.Employee;
import com.vitech.studentmanagement.model.Role;
import com.vitech.studentmanagement.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeDao employeeDao = new EmployeeDaoImpl();
	
	public List<Employee> findAll(Role role) {
		return employeeDao.findAll(role);
	}

	public boolean add(Role role, Employee employee) {
		return employeeDao.add(role, employee);
	}

	public Employee find(Role role, String maNV) {
		return employeeDao.find(role, maNV);
	}

	public boolean update(Role role, Employee employee) {
		return employeeDao.update(role, employee);
	}

	public boolean seftUpdate(Role role, Employee employee) {
		return employeeDao.seftUpdate(role, employee);
	}
}
