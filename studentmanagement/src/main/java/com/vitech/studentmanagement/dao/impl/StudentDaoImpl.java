package com.vitech.studentmanagement.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vitech.studentmanagement.dao.StudentDao;
import com.vitech.studentmanagement.databasehelper.DBProvider;
import com.vitech.studentmanagement.model.Role;
import com.vitech.studentmanagement.model.Student;

public class StudentDaoImpl implements StudentDao {

	public List<Student> find(Role role) {
		List<Student> students = new ArrayList<Student>();
		String sql = "select * from dbasv.SINH_VIEN";
		try {
			Connection connection = DBProvider.connectOracelDB(role);
			PreparedStatement preparedStatement = connection
					.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Student student = new Student();
				student.setMaSv(rs.getString("MA_SV"));
				student.setTenSv(rs.getString("TEN_SV"));
				student.setNgaySinh(rs.getString("NGAY_SINH"));
				student.setGioiTinh(rs.getString("GIOI_TINH"));
				student.setDiaChi(rs.getString("DIA_CHI_LL"));
				student.setSoDienThoai(rs.getString("SDT"));
				student.setMaNganh(rs.getString("MA_NGANH"));
				students.add(student);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return students;
	}

	public Student findById(Role role, String maSv) {
		Student student = new Student();
		String sql = "select * from dbasv.SINH_VIEN where MA_SV = ?";
		try {
			Connection connection = DBProvider.connectOracelDB(role);
			PreparedStatement preparedStatement = connection
					.prepareStatement(sql);
			preparedStatement.setString(1, maSv);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				student.setMaSv(rs.getString("MA_SV"));
				student.setTenSv(rs.getString("TEN_SV"));
				student.setNgaySinh(rs.getString("NGAY_SINH"));
				student.setGioiTinh(rs.getString("GIOI_TINH"));
				student.setDiaChi(rs.getString("DIA_CHI_LL"));
				student.setSoDienThoai(rs.getString("SDT"));
				student.setMaNganh(rs.getString("MA_NGANH"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return student;
	}

	public boolean update(Role role, Student student) {
		boolean result = false;
		String sql = "update dbasv.SINH_VIEN set TEN_SV = '"+student.getTenSv()+"', "
				+ "GIOI_TINH = '"+student.getGioiTinh()+"', "
				+ "DIA_CHI_LL = '"+student.getDiaChi()+"', "
				+ "SDT = '"+student.getSoDienThoai()+"', "
				+ "NGAY_SINH = to_date('"+student.getNgaySinh()+"', 'yyyy-MM-dd') "
				+ "where MA_SV = '"+student.getMaSv()+"'";
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

	public boolean seftUpdate(Role role, Student student) {
		boolean result = false;
		String sql = "update dbasv.SINH_VIEN set TEN_SV = '"+student.getTenSv()+"', "
				+ "GIOI_TINH = '"+student.getGioiTinh()+"', "
				+ "DIA_CHI_LL = '"+student.getDiaChi()+"', "
				+ "SDT = '"+student.getSoDienThoai()+"', "
				+ "NGAY_SINH = to_date('"+student.getNgaySinh()+"', 'yyyy-MM-dd') ";
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

	public boolean add(Role role, Student student) {
		boolean result = false;
		String sql = "insert into dbasv.SINH_VIEN(MA_SV, TEN_SV, NGAY_SINH, GIOI_TINH, DIA_CHI_LL, SDT, MA_NGANH) values("
				+ "'"+student.getMaSv()+"', "
				+ "'"+student.getTenSv()+"', "
				+ "to_date( '"+student.getNgaySinh()+"','yyyy-MM-dd'),"
				+ "'"+student.getGioiTinh()+"', "
				+ "'"+student.getDiaChi()+"', "
				+ "'"+student.getSoDienThoai()+"', "
				+ "'"+student.getMaNganh()+"' )"; 
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
