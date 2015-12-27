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

	public boolean add(Role role, Schedule schedule) {
		boolean result = false;
		String sql = "insert into dbasv.GIANG_DAY(MA_NV, MA_MH, MA_HK, VAI_TRO) values ('"+schedule.getMaNV()+"','"+schedule.getMaMH()+"','"+schedule.getMaHK()+"','"+schedule.getVaiTro()+"')"; 
		try {
			Connection connection = DBProvider.connectOracelDB(role);
			PreparedStatement preparedStatement = connection
					.prepareStatement(sql);
			int rs = preparedStatement.executeUpdate();
			if (rs > 0) {
				result = true;
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return result;
	}

	public Schedule findById(Role role, String subjectCode, String employeeCode) {
		Schedule schedule = new Schedule();
		String sql = "select * from dbasv.GIANG_DAY where MA_NV = ? and MA_MH = ? ";
		try {
			Connection connection = DBProvider.connectOracelDB(role);
			PreparedStatement preparedStatement = connection
					.prepareStatement(sql);
			preparedStatement.setString(1, employeeCode);
			preparedStatement.setString(2, subjectCode);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				schedule.setMaMH(rs.getString("MA_MH"));
				schedule.setMaNV(rs.getString("MA_NV"));
				schedule.setMaHK(rs.getString("MA_HK"));
				schedule.setVaiTro(rs.getString("VAI_TRO"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return schedule;
	}

	public boolean update(Role role, Schedule schedule) {
		boolean result = false;
		String sql = "update dbasv.GIANG_DAY set VAI_TRO = ? where MA_NV = ? and MA_MH = ?"; 
		try {
			Connection connection = DBProvider.connectOracelDB(role);
			PreparedStatement preparedStatement = connection
					.prepareStatement(sql);
			preparedStatement.setString(1, schedule.getVaiTro());
			preparedStatement.setString(2, schedule.getMaNV());
			preparedStatement.setString(3, schedule.getMaMH());
			int rs = preparedStatement.executeUpdate();
			if (rs > 0) {
				result = true;
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return result;
	}

}
