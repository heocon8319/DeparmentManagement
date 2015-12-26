package com.java.testing;

import java.util.List;

import com.vitech.studentmanagement.dao.EmployeeDao;
import com.vitech.studentmanagement.dao.impl.EmployeeDaoImpl;
import com.vitech.studentmanagement.model.Employee;
import com.vitech.studentmanagement.model.Role;

public class EmployeeTesting {

	static EmployeeDao employeeDao = new EmployeeDaoImpl();
	
	public static void main(String[] agrs){
		Role role = new Role();
		role.setUserName("NV02");
		role.setPassword("1234");
		
		List<Employee> employees = employeeDao.findAll(role);
		for(Employee em: employees){
			System.out.println(em.getName());
		}
	}
}
