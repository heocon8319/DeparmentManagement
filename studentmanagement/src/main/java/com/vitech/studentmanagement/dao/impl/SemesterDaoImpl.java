package com.vitech.studentmanagement.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vitech.studentmanagement.dao.SemesterDao;
import com.vitech.studentmanagement.databasehelper.DBProvider;
import com.vitech.studentmanagement.model.Role;
import com.vitech.studentmanagement.model.Semester;

public class SemesterDaoImpl implements SemesterDao{

	public List<Semester> findAll(Role role) {
		List<Semester> semesters = new ArrayList<Semester>();
		String sql = "select * from dbasv.HOCKY_NAM";
		try {
			Connection connection = DBProvider.connectOracelDB(role);
			PreparedStatement preparedStatement = connection
					.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Semester semester = new Semester();
				semester.setMaHK(rs.getString("MA_HK"));
				semester.setNamHoc(rs.getInt("NAM_HOC"));
				semester.setHocKy(rs.getInt("HOC_KY"));
				semesters.add(semester);				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return semesters;
	}

}
