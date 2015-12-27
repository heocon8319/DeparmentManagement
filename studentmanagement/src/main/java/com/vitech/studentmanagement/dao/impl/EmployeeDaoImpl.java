package com.vitech.studentmanagement.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vitech.studentmanagement.dao.EmployeeDao;
import com.vitech.studentmanagement.databasehelper.DBProvider;
import com.vitech.studentmanagement.model.Employee;
import com.vitech.studentmanagement.model.Role;

public class EmployeeDaoImpl implements EmployeeDao {

	public List<Employee> findAll(Role role) {
		List<Employee> employees = new ArrayList<Employee>();
		String sql = "select * from dbasv.NHAN_VIEN";
		try {
			Connection connection = DBProvider.connectOracelDB(role);
			PreparedStatement preparedStatement = connection
					.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Employee employee = new Employee();
				employee.setAddress(rs.getString("DIA_CHI_LL"));
				employee.setBonus(rs.getInt("PHU_CAP"));
				employee.setCode(rs.getString("MA_NV"));
				employee.setDob(rs.getString("NAM_SINH"));
				employee.setHomeTown(rs.getString("QUE_QUAN"));
				employee.setManagerCode(rs.getString("MA_NQL"));
				employee.setName(rs.getString("TEN_NV"));
				employee.setPhone(rs.getString("SDT"));
				employee.setRoleCode(rs.getString("MA_NHIEM_VU"));
				employee.setSalary(rs.getInt("LUONG"));
				employee.setSex(rs.getString("GIOI_TINH"));
				employees.add(employee);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employees;
	}

	public boolean add(Role role, Employee employee) {
		boolean result = false;
		String sql = "insert into dbasv.NHAN_VIEN(MA_NV, TEN_NV, NAM_SINH, GIOI_TINH, DIA_CHI_LL, SDT, LUONG, PHU_CAP, QUE_QUAN, MA_NQL, MA_NHIEM_VU)values('"
				+ employee.getCode()
				+ "', '"
				+ employee.getName()
				+ "', to_date( '"
				+ employee.getDob()
				+ "','yyyy-MM-dd'),'"
				+ employee.getSex()
				+ "', '"
				+ employee.getAddress()
				+ "', '"
				+ employee.getPhone()
				+ "', "
				+ employee.getSalary()
				+ ", "
				+ employee.getBonus()
				+ ", '"
				+ employee.getHomeTown()
				+ "', '"
				+ employee.getManagerCode()
				+ "', '"
				+ employee.getRoleCode()
				+ "' )";
		try {
			Connection connection = DBProvider.connectOracelDB(role);
			PreparedStatement preparedStatement = connection
					.prepareStatement(sql);
			int rs = preparedStatement.executeUpdate();
			if (rs > 0) {
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public boolean update(Role role, Employee employee) {
		boolean result = false;
		String sql = "update dbasv.NHAN_VIEN set TEN_NV = '"
				+ employee.getName() + "', NAM_SINH = to_date('"
				+ employee.getDob() + "', 'yyyy-MM-dd') , GIOI_TINH='"
				+ employee.getSex() + "', DIA_CHI_LL='" + employee.getAddress()
				+ "', SDT='" + employee.getPhone() + "', LUONG="
				+ employee.getSalary() + ", PHU_CAP=" + employee.getBonus()
				+ ", QUE_QUAN='" + employee.getHomeTown() + "', MA_NQL='"
				+ employee.getManagerCode() + "', MA_NHIEM_VU='"
				+ employee.getRoleCode() + "' where MA_NV = '"
				+ employee.getCode() + "'";
		try {
			Connection connection = DBProvider.connectOracelDB(role);
			PreparedStatement preparedStatement = connection
					.prepareStatement(sql);
			int rs = preparedStatement.executeUpdate();
			if (rs > 0) {
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public Employee find(Role role, String maNV) {
		Employee employee = new Employee();
		String sql = "select * from dbasv.NHAN_VIEN where MA_NV = ?";
		try {
			Connection connection = DBProvider.connectOracelDB(role);
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, maNV);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				employee.setAddress(rs.getString("DIA_CHI_LL"));
				employee.setBonus(rs.getInt("PHU_CAP"));
				employee.setCode(rs.getString("MA_NV"));
				employee.setDob(rs.getString("NAM_SINH"));
				employee.setHomeTown(rs.getString("QUE_QUAN"));
				employee.setManagerCode(rs.getString("MA_NQL"));
				employee.setName(rs.getString("TEN_NV"));
				employee.setPhone(rs.getString("SDT"));
				employee.setRoleCode(rs.getString("MA_NHIEM_VU"));
				employee.setSalary(rs.getInt("LUONG"));
				employee.setSex(rs.getString("GIOI_TINH"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employee;
	}

	public boolean seftUpdate(Role role, Employee employee) {
		boolean result = false;
		String sql = "update dbasv.NHAN_VIEN set TEN_NV = '"+employee.getName() + "', NAM_SINH = to_date('"+ employee.getDob() + "', 'yyyy-MM-dd') , GIOI_TINH='"+ employee.getSex() + "', DIA_CHI_LL='" + employee.getAddress()+ "', SDT='" + employee.getPhone() + "', QUE_QUAN='"+employee.getHomeTown()+"' where MA_NV = '"+ employee.getCode() + "'";
		try {
			Connection connection = DBProvider.connectOracelDB(role);
			PreparedStatement preparedStatement = connection
					.prepareStatement(sql);
			int rs = preparedStatement.executeUpdate();
			if (rs > 0) {
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
