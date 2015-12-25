package com.vitech.studentmanagement.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vitech.studentmanagement.dao.TeacherDao;
import com.vitech.studentmanagement.databasehelper.DBProvider;
import com.vitech.studentmanagement.model.Role;
import com.vitech.studentmanagement.model.Teacher;

public class TeacherDaoImpl implements TeacherDao{

	public List<Teacher> findAll(Role role) {
		List<Teacher> teachers = new ArrayList<Teacher>();
		String sql = "select * from dbasv.NHAN_VIEN";
		try {
			Connection connection = DBProvider.connectOracelDB(role);
			PreparedStatement preparedStatement = connection
					.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Teacher teacher = new Teacher();
				teacher.setDiaChi(rs.getString("DIA_CHI_LL"));
				teacher.setGioiTinh(rs.getString("GIOI_TINH"));
				teacher.setLuong(rs.getInt("LUONG"));
				teacher.setMaNhiemVu(rs.getString("MA_NHIEM_VU"));
				teacher.setMaNv(rs.getString("MA_NV"));
				teacher.setNamSinh(rs.getString("NAM_SINH"));
				teacher.setPhuCap(rs.getInt("PHU_CAP"));
				teacher.setQuanHe(rs.getString("QUE_QUAN"));
				teacher.setSoDienThoai(rs.getString("SDT"));
				teacher.setTenNv(rs.getString("TEN_NV"));
				teachers.add(teacher);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return teachers;
	}

	public boolean seftUpdate(Role role, Teacher teacher) {
		boolean result = false;
		String sql = "update dbasv.NHAN_VIEN set TEN_NV = '"+teacher.getTenNv()+"', "
				+ "GIOI_TINH = '"+teacher.getGioiTinh()+"', "
				+ "DIA_CHI_LL = '"+teacher.getDiaChi()+"', "
				+ "SDT = '"+teacher.getSoDienThoai()+"', "
				+ "NAM_SINH = to_date('"+teacher.getNamSinh()+"', 'yyyy-MM-dd') ";
		try {
			Connection connection = DBProvider.connectOracelDB(role);
			PreparedStatement preparedStatement = connection
					.prepareStatement(sql);
			int rs = preparedStatement.executeUpdate();
			if (rs > 0) {
				result = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}
