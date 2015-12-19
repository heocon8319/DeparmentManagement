package com.vitech.studentmanagement.service.Impl;

import com.vitech.studentmanagement.dao.UserDao;
import com.vitech.studentmanagement.dao.impl.UserDaoImpl;
import com.vitech.studentmanagement.model.Employee;
import com.vitech.studentmanagement.service.UserService;
import com.vitech.studentmanagement.utility.Utilities;

public class UserServiceImpl implements UserService{

	UserDao userDao = new UserDaoImpl();
	
	public int addEmployee(Employee employee) {
		
		String passwordEncoded = Utilities.encodePassword(employee.getPassword());
		employee.setPassword(passwordEncoded);
		employee.setCreatedDate(Utilities.getCurrentDate());
		return userDao.addEmployee(employee);
	}

	public Employee findByNameAndPass(String userName, String password) {
		//password = Utilities.encodePassword(password);
		//return userDao.findByNameAndPass(userName, password);
		Employee emp = new Employee();
		if(userName.equals("admin") && password.equals("admin")){
			emp.setId(1);
			emp.setImage("/app/avatar_icon.png");
			emp.setCode("AD001");
			emp.setName("Nhut Nguyen");
		}else{
			emp.setId(0);
		}
		return emp;
	}

	public Employee find(String userName, String password) {
		Employee employee = new Employee();
		employee.setUserName(userName);
		employee.setPassword(password);
		return userDao.find(employee);
	}
}
