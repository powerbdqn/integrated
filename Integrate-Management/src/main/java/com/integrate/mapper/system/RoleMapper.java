package com.integrate.mapper.system;

import java.util.List;

import com.integrate.pojo.system.Role;

public interface RoleMapper {

	List<Role> listRoles();

	List<Role> getRoleListByUserId(Integer id);

	Role getRoleById(Integer id);

	void saveRole(Role role);
}