package com.integrate.service.system.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.integrate.mapper.system.UserMapper;
import com.integrate.pojo.system.User;
import com.integrate.service.system.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	@Override
	public User findByUserName(String username) {
		return userMapper.findByUsername(username);
	}
	@Override
	public List<User> listUsers() {
		return userMapper.listUsers();
	}
}
