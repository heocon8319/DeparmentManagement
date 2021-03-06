package com.vitech.studentmanagement.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vitech.studentmanagement.dao.SubjectDao;
import com.vitech.studentmanagement.databasehelper.DBProvider;
import com.vitech.studentmanagement.model.Role;
import com.vitech.studentmanagement.model.Subject;
import com.vitech.studentmanagement.model.SubjectOpen;
import com.vitech.studentmanagement.model.SubjectSpeciality;

public class SubjectDaoImpl implements SubjectDao {

	public List<Subject> find(Role role, int year, int semester) {
		List<Subject> subjects = new ArrayList<Subject>();
		String sql = "select MH.MA_MH, MH.TEN_MH, MH.SO_TIN_CHI, HKN.NAM_HOC, HKN.HOC_KY "
				+ "from dbasv.MON_HOC MH, dbasv.MONHOC_MO MHM, dbasv.HOCKY_NAM HKN "
				+ "where MH.MA_MH = MHM.MA_MH  and MHM.MA_HK = HKN.MA_HK and HKN.HOC_KY = ? and HKN.NAM_HOC = ?";
		try {
			Connection connection = DBProvider.connectOracelDB(role);
			PreparedStatement preparedStatement = connection
					.prepareStatement(sql);
			preparedStatement.setInt(1, semester);
			preparedStatement.setInt(2, year);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Subject subject = new Subject();
				subject.setMaMH(rs.getString("MA_MH"));
				subject.setTenMH(rs.getString("TEN_MH"));
				subject.setSoTinChi(rs.getInt("SO_TIN_CHI"));
				subject.setNam(rs.getInt("NAM_HOC"));
				subject.setHocKy(rs.getInt("HOC_KY"));
				subjects.add(subject);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return subjects;
	}

	public List<Subject> findAll(Role role) {
		List<Subject> subjects = new ArrayList<Subject>();
		String sql = "select * from dbasv.MON_HOC";
		try {
			Connection connection = DBProvider.connectOracelDB(role);
			PreparedStatement preparedStatement = connection
					.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Subject subject = new Subject();
				subject.setMaMH(rs.getString("MA_MH"));
				subject.setTenMH(rs.getString("TEN_MH"));
				subject.setSoTinChi(rs.getInt("SO_TIN_CHI"));
				subjects.add(subject);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return subjects;
	}

	public List<SubjectSpeciality> getSubjectSpeciality(Role role) {
		List<SubjectSpeciality> subjectSpecialities = new ArrayList<SubjectSpeciality>();
		String sql = "select * from dbasv.MONHOC_NGANH";
		try {
			Connection connection = DBProvider.connectOracelDB(role);
			PreparedStatement preparedStatement = connection
					.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				SubjectSpeciality subject = new SubjectSpeciality();
				subject.setMaMH(rs.getString("MA_MH"));
				subject.setMaNganh(rs.getString("MA_NGANH"));
				subject.setBatBuoc(rs.getString("BAT_BUOC"));
				subjectSpecialities.add(subject);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return subjectSpecialities;
	}

	public boolean addSubjectSpeciality(Role role,
			SubjectSpeciality subjectSpeciality) {
		boolean result = false;
		String sql = "insert into dbasv.MONHOC_NGANH(MA_MH, MA_NGANH, BAT_BUOC)values(?, ?, ?)";
		try {
			Connection connection = DBProvider.connectOracelDB(role);
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, subjectSpeciality.getMaMH());
			preparedStatement.setString(2, subjectSpeciality.getMaNganh());
			preparedStatement.setString(3, subjectSpeciality.getBatBuoc());
			int rs = preparedStatement.executeUpdate();
			if (rs > 0) {
				result = true;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

	public List<SubjectOpen> getSubjectOpen(Role role) {
		List<SubjectOpen> subjectOpens = new ArrayList<SubjectOpen>();
		String sql = "select * from dbasv.MONHOC_MO";
		try {
			Connection connection = DBProvider.connectOracelDB(role);
			PreparedStatement preparedStatement = connection
					.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				SubjectOpen subject = new SubjectOpen();
				subject.setMaMH(rs.getString("MA_MH"));
				subject.setMaHK(rs.getString("MA_HK"));
				subject.setNgayBD(rs.getString("NGAY_BD"));
				subject.setNgayKT(rs.getString("NGAY_KT"));
				subject.setSoLuongSV(rs.getInt("SO_LUONG_SV"));
				subjectOpens.add(subject);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return subjectOpens;
	}

	public boolean addSubjectOpen(Role role, SubjectOpen subjectOpen) {
		boolean result = false;
		String sql = "insert into dbasv.MONHOC_MO(MA_MH, MA_HK, NGAY_BD, NGAY_KT, SO_LUONG_SV) values ('"+subjectOpen.getMaMH()+"', '"+subjectOpen.getMaHK()+"', to_date( '"+subjectOpen.getNgayBD()+"','yyyy-MM-dd'), to_date( '"+subjectOpen.getNgayKT()+"','yyyy-MM-dd'), "+subjectOpen.getSoLuongSV()+")";
		try {
			Connection connection = DBProvider.connectOracelDB(role);
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
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
