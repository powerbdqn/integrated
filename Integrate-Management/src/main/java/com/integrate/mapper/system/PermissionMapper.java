package com.integrate.mapper.system;

import java.util.List;

import com.integrate.pojo.system.Permission;

public interface PermissionMapper {
/*    int deleteByPrimaryKey(Integer id);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);*/

	List<Permission> listPermissions();
}