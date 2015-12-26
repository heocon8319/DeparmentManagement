package com.vitech.studentmanagement.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vitech.studentmanagement.dao.RegisterSubjectDao;
import com.vitech.studentmanagement.databasehelper.DBProvider;
import com.vitech.studentmanagement.model.RegisterSubject;
import com.vitech.studentmanagement.model.Role;

public class RegisterSubjectDaoImpl implements RegisterSubjectDao{

	public List<RegisterSubject> findAll(Role role) {
		List<RegisterSubject> registerSubjects = new ArrayList<RegisterSubject>();
		String sql = "select * from dbasv.DANG_KY";
		try {
			Connection connection = DBProvider.connectOracelDB(role);
			PreparedStatement preparedStatement = connection
					.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				RegisterSubject registerSubject = new RegisterSubject();
				registerSubject.setSubjectCode(rs.getString("MA_MH"));
				registerSubject.setStudentCode(rs.getString("MA_SV"));
				registerSubject.setSemester(rs.getString("MA_HK"));
				registerSubject.setPeriodDate(rs.getString("HAN_DANG_KY"));
				registerSubject.setScore(rs.getInt("DIEM"));
				registerSubjects.add(registerSubject);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return registerSubjects;
	}

}
