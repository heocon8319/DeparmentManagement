package com.vitech.studentmanagement.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.vitech.studentmanagement.dao.UserDao;
import com.vitech.studentmanagement.databasehelper.DBProvider;
import com.vitech.studentmanagement.model.Employee;
import com.vitech.studentmanagement.utility.Utilities;

public class UserDaoImpl implements UserDao {

	public int addEmployee(Employee employee) {
		StringBuilder sql = new StringBuilder()
				.append("insert into employee(code, name, phone, DOB, image, role, identify, user_name, password, status, created_date)")
				.append(" values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		int result = 0;
		try {
			Connection connection = DBProvider.connectDB();
			PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
			preparedStatement.setString(1, employee.getCode());
			preparedStatement.setString(2, employee.getName());
			preparedStatement.setString(3, employee.getPhone());
			preparedStatement.setString(4, employee.getDOB());
			preparedStatement.setString(5, employee.getImage());
			preparedStatement.setInt(6, employee.getRole());
			preparedStatement.setString(7, employee.getIdentify());
			preparedStatement.setString(8, employee.getUserName());
			preparedStatement.setString(9, employee.getPassword());
			preparedStatement.setString(10, employee.getStatus());
			preparedStatement.setString(11, employee.getCreatedDate());
			result = preparedStatement.executeUpdate();
			if (result == 1) {
				// get id employee's id just inserted;
				ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
				if (generatedKeys.next()) {
					result = generatedKeys.getInt(1);
				}
			}
			preparedStatement.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public Employee findByNameAndPass(String userName, String password) {
		String sql = "select id, code, name, image, role from employee where user_name = ? and password=? and status= ? ";
		Employee employee=new Employee();
		try {
			Connection connection = DBProvider.connectDB();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userName);
			preparedStatement.setString(2, password);
			preparedStatement.setString(3, Utilities.STATUS_ACTIVE);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String code = resultSet.getString("code");
				String name = resultSet.getString("name");
				String image = resultSet.getString("image");
				int role = resultSet.getInt("role");
				
				employee = new Employee(id, code, name, image, role);
			}
			
			preparedStatement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employee;
	}

	public Employee find(Employee employee) {
		Connection conn = DBProvider.connectOracelDB(employee);
		if(conn != null){
			employee.setId(1);
			employee.setImage("/app/avatar_icon.png");
			employee.setCode("AD001");
			employee.setName("Nhut Nguyen");
		}else{
			employee.setId(0);
		}
		return employee;
	}
}
