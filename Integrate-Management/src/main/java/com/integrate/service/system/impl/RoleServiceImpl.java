package com.integrate.service.system.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.integrate.mapper.system.RoleMapper;
import com.integrate.pojo.system.Role;
import com.integrate.pojo.system.User;
import com.integrate.service.system.RoleService;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleMapper roleMapper;
	
	@Override
	public List<Role> findByUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Role> listRoles() {
		return roleMapper.listRoles();
	}

}
