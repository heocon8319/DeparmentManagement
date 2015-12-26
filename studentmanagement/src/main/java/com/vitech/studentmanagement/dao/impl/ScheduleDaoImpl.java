package com.vitech.studentmanagement.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vitech.studentmanagement.dao.ScheduleDao;
import com.vitech.studentmanagement.databasehelper.DBProvider;
import com.vitech.studentmanagement.model.Role;
import com.vitech.studentmanagement.model.Schedule;

public class ScheduleDaoImpl implements ScheduleDao{

	public List<Schedule> findAll(Role role) {
		List<Schedule> schedules = new ArrayList<Schedule>();
		String sql = "  select * from dbasv.GIANG_DAY";
		try {
			Connection connection = DBProvider.connectOracelDB(role);
			PreparedStatement preparedStatement = connection
					.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Schedule schedule = new Schedule();
				schedule.setMaMH(rs.getString("MA_MH"));
				schedule.setMaNV(rs.getString("MA_NV"));
				schedule.setMaHK(rs.getString("MA_HK"));
				schedule.setVaiTro(rs.getString("VAI_TRO"));
				schedules.add(schedule);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return schedules;
	}

}
