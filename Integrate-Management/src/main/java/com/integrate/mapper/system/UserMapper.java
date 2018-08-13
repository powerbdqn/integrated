package com.integrate.mapper.system;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.integrate.pojo.system.User;

public interface UserMapper {

	User findByUsername(String username);

	List<User> listUsers();

	User checkUserCard(@Param("cord") String cord);

	void updateUserByPrimaryKey(User user);

	void insertUser(User user);

	/*void updateByPrimaryKeySelective(User user);*/

	User selectByPrimaryKey(Integer id);

}