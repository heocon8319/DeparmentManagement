package com.java.testing;

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
		
		Employee em = new Employee();
		em.setAddress("Hai Ba Trung, HCM");
		em.setBonus(1000);
		em.setCode("NV22");
		em.setDob("1990-04-14");
		em.setHomeTown("HCM");
		em.setManagerCode("NV04");
		em.setName("Ma Vinh Trinh");
		em.setPhone("0909888777");
		em.setRoleCode("GVi");
		em.setSalary(1500);
		em.setSex("Nam");
		
		boolean rs = employeeDao.add(role, em);
		System.out.println(rs);
		
//		List<Employee> employees = employeeDao.findAll(role);
//		for(Employee em: employees){
//			System.out.println(em.getName());
//		}
	}
}
