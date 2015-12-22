package com.vitech.studentmanagement.databasehelper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.vitech.studentmanagement.model.Role;
import com.vitech.studentmanagement.utility.Utilities;
public class DBProvider {
	
	public static Connection connectDB(){
		Connection connection = null;
		try {
			Class.forName(Utilities.JDBC_DRIVER);
			connection = DriverManager.getConnection(Utilities.DB_URL, Utilities.DB_USER, Utilities.DB_PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	public static Connection connectOracelDB(Role employee){
		Connection connection = null;
		try {
			Class.forName(Utilities.OJDBC_DRIVER);
			connection = DriverManager.getConnection(Utilities.ODB_URL, employee.getUserName(), employee.getPassword());
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch(SQLException ex){
			System.out.println(ex.getMessage());
		}
		return connection;
	}
}
