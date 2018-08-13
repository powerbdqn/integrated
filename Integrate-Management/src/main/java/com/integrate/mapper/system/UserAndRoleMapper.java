package com.integrate.mapper.system;

import org.apache.ibatis.annotations.Param;

import com.integrate.pojo.system.UserAndRoleKey;

public interface UserAndRoleMapper {
    int deleteByPrimaryKey(UserAndRoleKey key);

    int insert(UserAndRoleKey record);

    int insertSelective(UserAndRoleKey record);

	void deleteByUserIdAndRoleId(@Param("userId")Integer userId,@Param("roleId") Integer roleId);

	void deleteByUserId(@Param("userId")Integer userId);
}