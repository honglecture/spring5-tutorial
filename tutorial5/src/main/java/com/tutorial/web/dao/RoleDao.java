package com.tutorial.web.dao;

import java.util.List;

import com.tutorial.web.entity.Role;

public interface RoleDao {
	
	int insert(Role role);
	
	int update(Role role);
	
	int delete(String name);
	
	Role get(String name);
	
	List<Role> getList();

}
