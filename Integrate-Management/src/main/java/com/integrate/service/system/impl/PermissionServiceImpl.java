package com.integrate.service.system.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.integrate.mapper.system.PermissionMapper;
import com.integrate.pojo.system.Permission;
import com.integrate.pojo.system.User;
import com.integrate.service.system.PermissionService;

@Service
@Transactional
public class PermissionServiceImpl implements PermissionService {

	@Autowired
	private PermissionMapper permissionMapper;
	
	@Override
	public List<Permission> findByUser(User user) {
		return null;
	}

	@Override
	public List<Permission> listPermissions() {
		return permissionMapper.listPermissions();
	}

}
