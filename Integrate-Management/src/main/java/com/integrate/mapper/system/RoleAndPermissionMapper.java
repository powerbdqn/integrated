package com.integrate.mapper.system;

import com.integrate.pojo.system.RoleAndPermissionKey;

public interface RoleAndPermissionMapper {
    int deleteByPrimaryKey(RoleAndPermissionKey key);

    int insert(RoleAndPermissionKey record);

    int insertSelective(RoleAndPermissionKey record);
}