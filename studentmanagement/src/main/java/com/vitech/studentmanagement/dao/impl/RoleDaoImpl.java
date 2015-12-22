package com.vitech.studentmanagement.dao.impl;

import java.sql.Connection;

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

}
