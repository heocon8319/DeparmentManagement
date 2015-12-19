package com.vitech.studentmanagement.service;

import com.vitech.studentmanagement.model.Employee;

public interface UserService {

	public int addEmployee(Employee employee);
	public Employee findByNameAndPass(String userName, String password);
	public Employee find(String userName, String password);
}
