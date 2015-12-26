package com.vitech.studentmanagement.dao;

import java.util.List;

import com.vitech.studentmanagement.model.Role;

public interface RoleDao {
	public Role find(Role role);
	
	public List<Role> findAll(Role role);
}
