package com.integrate.mapper.system;

import java.util.List;

import com.integrate.pojo.system.User;

public interface UserMapper {
/*    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);*/

	User findByUsername(String username);

	List<User> listUsers();

}