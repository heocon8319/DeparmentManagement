package com.java.testing;

import com.vitech.studentmanagement.model.Employee;
import com.vitech.studentmanagement.service.UserService;
import com.vitech.studentmanagement.service.Impl.UserServiceImpl;

public class UserTest {

	UserService userService = new UserServiceImpl();
	
	public void insertUser(){
		
		Employee employee = new Employee("SC001", "Cao Minh Nhut", "caominhnhut", "123", "123456789", "0902524347", "/asset/avatar.pnj", "1990-04-14", 1);
		int x = userService.addEmployee(employee);
		
		System.out.println("Kq: "+x);
	}
	
	public void find(){
		String us = "caominhnhut1";
		String pass = "123";
		Employee e = userService.findByNameAndPass(us, pass);
		System.out.println(e.getId());
		System.out.println(e.getCode());
		System.out.println(e.getName());
		System.out.println(e.getImage());
		System.out.println(e.getRole());
	}
	
	public static void main(String args[]) throws Exception{
		UserTest userTest= new UserTest();
		userTest.find();
    }
}
