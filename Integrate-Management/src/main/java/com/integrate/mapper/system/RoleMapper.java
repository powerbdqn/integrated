package com.integrate.mapper.system;

import java.util.List;

import com.integrate.pojo.system.Role;

public interface RoleMapper {

	List<Role> listRoles();

	List<Role> getRoleListByUserId(Integer id);

	Role getRoleById(Integer id);

	int saveRole(Role role);

	Integer saveRoleAndBackPermaryKey(Role role);

	int updateRole(Role role);
}