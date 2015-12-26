package com.vitech.studentmanagement.service.Impl;

import java.util.List;

import com.vitech.studentmanagement.dao.RoleDao;
import com.vitech.studentmanagement.dao.impl.RoleDaoImpl;
import com.vitech.studentmanagement.model.Role;
import com.vitech.studentmanagement.service.RoleService;

public class RoleServiceImpl implements RoleService{

	private RoleDao roleDao = new RoleDaoImpl();
	
	public Role find(String userName, String password) {
		Role role = new Role();
		role.setUserName(userName);
		role.setPassword(password);
		role = roleDao.find(role);
		return role;
	}

	public List<Role> findAll(Role role) {
		return roleDao.findAll(role);
	}

}
