package com.integrate.service.system.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import com.integrate.mapper.system.RoleMapper;
import com.integrate.pojo.system.Role;
import com.integrate.pojo.system.User;
import com.integrate.service.system.RoleService;
import com.integrate.tool.MapTool;
import com.integrate.tool.MyConstants;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleMapper roleMapper;
	
	@Override
	public List<Role> findByUser(User user) {
		if("admin".equals(user.getUsername())) {
			return roleMapper.listRoles();
		}else {
			return roleMapper.getRoleListByUserId(user.getId());
		}
	}

	@Override
	public List<Role> listRoles() {
		return roleMapper.listRoles();
	}

	@Override
	public ModelAndView showRoleWindow(Integer id) {
		ModelAndView model = new ModelAndView();
		if(id != null) {
			Role role = roleMapper.getRoleById(id);
			model.addObject("role",role);
		}
		model.setViewName("system/role/role_add");
		return model;
	}

	@Override
	public Map<String, Object> saveRole(Role role) {
		Map<String,Object> map = new HashMap<>();
		try {
			User user = (User) SecurityUtils.getSubject().getPrincipal();
			role.setCreateTime(new Date());
			role.setCreateUser(user.getNickName());
			role.setMdifyTime(new Date());
			role.setModifyUser(user.getNickName());
			role.setProhibition(MyConstants.DATA_PROHIBITION_NO);
			role.setStatus(MyConstants.DATA_STATUS_NO);
			roleMapper.saveRole(role);
			map = MapTool.createMessageMap(2000, "保存成功", null);
		} catch (Exception e) {
			map = MapTool.createMessageMap(5000, "保存失败", null);
		}
		
		return map;
	}

}
