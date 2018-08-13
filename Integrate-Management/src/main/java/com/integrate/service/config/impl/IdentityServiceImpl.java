package com.integrate.service.config.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.integrate.mapper.config.IdentityMapper;
import com.integrate.pojo.config.Identity;
import com.integrate.service.config.IdentityService;

@Service
@Transactional
public class IdentityServiceImpl implements IdentityService {

	@Autowired
	private IdentityMapper identityMapper;
	@Override
	public List<Identity> listIdentity() {
		return identityMapper.listIdentity();
	}

}
