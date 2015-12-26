package com.vitech.studentmanagement.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vitech.studentmanagement.dao.RoleDao;
import com.vitech.studentmanagement.databasehelper.DBProvider;
import com.vitech.studentmanagement.model.Role;

public class RoleDaoImpl implements RoleDao{

	public Role find(Role role) {
		Connection conn = DBProvider.connectOracelDB(role);
		if(conn != null){
			role.setId(1);
			role.setImage("/app/avatar_icon.png");
			role.setCode("AD001");
			role.setName("Nhut Nguyen");
		}else{
			role.setId(0);
		}
		return role;
	}

	public List<Role> findAll(Role role) {
		List<Role> roles = new ArrayList<Role>();
		String sql = "select * from dbasv.NHIEM_VU";
		try {
			Connection connection = DBProvider.connectOracelDB(role);
			PreparedStatement preparedStatement = connection
					.prepareStatement(sql);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Role rl = new Role();
				rl.setName(rs.getString("TEN_NHIEM_VU"));
				rl.setCode(rs.getString("MA_NHIEM_VU"));
				roles.add(rl);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return roles;
	}

}
