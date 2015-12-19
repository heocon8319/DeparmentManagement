package com.vitech.studentmanagement.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vitech.studentmanagement.dao.NhiemVuDao;
import com.vitech.studentmanagement.databasehelper.DBProvider;
import com.vitech.studentmanagement.model.Employee;
import com.vitech.studentmanagement.model.NhiemVu;

public class NhiemVuIDaompl implements NhiemVuDao{

	public List<NhiemVu> find(Employee employee) {
		List<NhiemVu> nhiemVus = new ArrayList<NhiemVu>();
		String sql = "select * from nhiem_vu";
		try {
			Connection connection = DBProvider.connectOracelDB(employee);
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String maNhiemVu = resultSet.getString("MA_NHIEM_VU");
				String tenNhiemVu = resultSet.getString("TEN_NHIEM_VU");
				NhiemVu nv = new NhiemVu(maNhiemVu, tenNhiemVu);
				nhiemVus.add(nv);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nhiemVus;
	}

	
}
