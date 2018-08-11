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

import com.integrate.mapper.system.RoleAndMenuMapper;
import com.integrate.mapper.system.RoleAndPermissionMapper;
import com.integrate.mapper.system.RoleMapper;
import com.integrate.pojo.system.Role;
import com.integrate.pojo.system.RoleAndMenuKey;
import com.integrate.pojo.system.RoleAndPermissionKey;
import com.integrate.pojo.system.User;
import com.integrate.service.system.RoleService;
import com.integrate.tool.MapTool;
import com.integrate.tool.MyConstants;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleMapper roleMapper;
	
	@Autowired
	private RoleAndMenuMapper roleAndMenuMapper;
	
	@Autowired
	private RoleAndPermissionMapper roleAndPermissionMapper;
	
	
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
	public Map<String, Object> saveRole(Role role, String[] permissionIds, String menuIds) {
		
		Map<String,Object> map = new HashMap<>();
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		try {
			role.setCreateTime(new Date());
			role.setCreateUser(user.getNickName());
			role.setMdifyTime(new Date());
			role.setModifyUser(user.getNickName());
			role.setProhibition(MyConstants.DATA_PROHIBITION_NO);
			role.setStatus(MyConstants.DATA_STATUS_NO);
			if(role.getId() == null) {
				roleMapper.saveRoleAndBackPermaryKey(role);
				Integer id = role.getId();
				if(permissionIds != null) {
					for (String string : permissionIds) {
						Integer permissionId = Integer.parseInt(string);
						RoleAndPermissionKey bpk = new RoleAndPermissionKey();
						bpk.setPermissionId(permissionId);
						bpk.setRoleId(id);
						roleAndPermissionMapper.insert(bpk);
					}
				}
				
				if(menuIds != null) {
					String[] split = menuIds.split(",");
					for (String string : split) {
						RoleAndMenuKey bmk = new RoleAndMenuKey();
						Integer menuId = Integer.parseInt(string);
						bmk.setMenuId(menuId);
						bmk.setRoleId(id);
						roleAndMenuMapper.insert(bmk);
					}
				}
			}else {
				role.setMdifyTime(new Date());
				role.setModifyUser(user.getNickName());
				roleMapper.updateRole(role);
				Integer id = role.getId();
				if(permissionIds != null) {
					for (String string : permissionIds) {
						Integer permissionId = Integer.parseInt(string);
						RoleAndPermissionKey bpk = new RoleAndPermissionKey();
						bpk.setPermissionId(permissionId);
						bpk.setRoleId(id);
						roleAndPermissionMapper.insert(bpk);
					}
				}
				
				if(menuIds != null) {
					String[] split = menuIds.split(",");
					for (String string : split) {
						RoleAndMenuKey bmk = new RoleAndMenuKey();
						Integer menuId = Integer.parseInt(string);
						bmk.setMenuId(menuId);
						bmk.setRoleId(id);
						roleAndMenuMapper.insert(bmk);
					}
				}
			}
			map = MapTool.createMessageMap(2000, "保存成功", null);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			map = MapTool.createMessageMap(5000, "保存失败", null);
			
		}
		return map;
		
	}

	@Override
	public Map<String, Object> updateOperate(Integer id, String prohibition) {
		Map<String,Object> map = new HashMap<>();
		if(id != null) {
			Role role = roleMapper.getRoleById(id);
			User user = (User) SecurityUtils.getSubject().getPrincipal();
			role.setMdifyTime(new Date());
			role.setModifyUser(user.getNickName());
			if(MyConstants.DATA_PROHIBITION_NO.equals(prohibition)) {
				role.setProhibition(MyConstants.DATA_PROHIBITION_OK);
			}else if(MyConstants.DATA_PROHIBITION_OK.equals(prohibition)) {
				role.setProhibition(MyConstants.DATA_PROHIBITION_NO);
			}
			if(roleMapper.updateRole(role) == 1) {
				map = MapTool.createMessageMap(2000, "操作成功", null);
			}else {
				map = MapTool.createMessageMap(5000, "操作失败", null);
			}
		}
		return map;
	}

	@Override
	public Map<String, Object> updateRoleByStatus(Integer id) {
		Map<String,Object> map = new HashMap<>();
		if(id != null) {
			Role role = roleMapper.getRoleById(id);
			User user = (User) SecurityUtils.getSubject().getPrincipal();
			role.setMdifyTime(new Date());
			role.setModifyUser(user.getNickName());
			role.setStatus(MyConstants.DATA_STATUS_OK);
			role.setProhibition(MyConstants.DATA_PROHIBITION_OK);
			if(roleMapper.updateRole(role) == 1) {
				map = MapTool.createMessageMap(2000, "操作成功", null);
			}else {
				map = MapTool.createMessageMap(5000, "操作失败", null);
			}
		}
		return map;
	}

}
