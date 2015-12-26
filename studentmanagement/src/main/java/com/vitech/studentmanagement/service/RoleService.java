package com.vitech.studentmanagement.service;

import java.util.List;

import com.vitech.studentmanagement.model.Role;

public interface RoleService {
	
	public Role find(String userName, String password);
	
	public List<Role> findAll(Role role);
}
