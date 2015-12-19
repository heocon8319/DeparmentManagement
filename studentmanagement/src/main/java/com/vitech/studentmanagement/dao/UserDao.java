package com.vitech.studentmanagement.dao;

import com.vitech.studentmanagement.model.Employee;

public interface UserDao {

	public int addEmployee(Employee employee);
	public Employee findByNameAndPass(String userName, String password);
	public Employee find(Employee employee);
}
