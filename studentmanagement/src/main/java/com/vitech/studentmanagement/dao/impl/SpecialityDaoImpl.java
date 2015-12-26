package com.vitech.studentmanagement.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.vitech.studentmanagement.dao.SpecialityDao;
import com.vitech.studentmanagement.databasehelper.DBProvider;
import com.vitech.studentmanagement.model.Role;
import com.vitech.studentmanagement.model.Speciality;

public class SpecialityDaoImpl implements SpecialityDao{

	public List<Speciality> findAll(Role role) {
		List<Speciality> specialities = new ArrayList<Speciality>();
		String sql = "select * from dbasv.NGANH";
		try {
			Connection connection = DBProvider.connectOracelDB(role);
			PreparedStatement preparedStatement = connection
					.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Speciality speciality = new Speciality();
				speciality.setMaNganh(rs.getString("MA_NGANH"));
				speciality.setTenNganh(rs.getString("TEN_NGANH"));
				speciality.setMaNQL(rs.getString("TRUONG_BO_MON"));
				specialities.add(speciality);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return specialities;
	}

}
