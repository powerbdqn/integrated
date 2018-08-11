package com.integrate.mapper.system;

import com.integrate.pojo.system.RoleAndMenuKey;

public interface RoleAndMenuMapper {
    int deleteByPrimaryKey(RoleAndMenuKey key);

    int insert(RoleAndMenuKey record);

    int insertSelective(RoleAndMenuKey record);
}