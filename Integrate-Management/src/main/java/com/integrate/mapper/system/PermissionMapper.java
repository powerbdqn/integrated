package com.integrate.mapper.system;

import java.util.List;

import com.integrate.pojo.system.Permission;

public interface PermissionMapper {

	List<Permission> listPermissions();

	void savePermission(Permission permission);

	List<Permission> getPermissionListByUserId(Integer id);

	Permission getPermissionById(Integer id);

	int updatePermission(Permission permission);

	List<Permission> listPermissionDataListByStatus();

	int deletePermissionByDB(Integer id);
}