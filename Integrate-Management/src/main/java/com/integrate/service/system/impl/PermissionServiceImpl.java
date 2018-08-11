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

import com.integrate.mapper.system.PermissionMapper;
import com.integrate.pojo.system.Permission;
import com.integrate.pojo.system.User;
import com.integrate.service.system.PermissionService;
import com.integrate.tool.MapTool;
import com.integrate.tool.MyConstants;

@Service
@Transactional
public class PermissionServiceImpl implements PermissionService {

	@Autowired
	private PermissionMapper permissionMapper;
	
	@Override
	public List<Permission> findByUser(User user) {
		if("admin".equals(user.getUsername())) {
			return permissionMapper.listPermissions();
		}else {
			return permissionMapper.getPermissionListByUserId(user.getId());
		}
	}

	@Override
	public List<Permission> listPermissions() {
		return permissionMapper.listPermissions();
	}

	@Override
	public Map<String,Object> savePermission(Permission permission) {
		Map<String,Object> map = new HashMap<>();
		try {
			User user = (User) SecurityUtils.getSubject().getPrincipal();
			permission.setCreateTime(new Date());
			permission.setCreateUser(user.getNickName());
			permission.setMdifyTime(new Date());
			permission.setModifyUser(user.getNickName());
			permission.setProhibition(MyConstants.DATA_PROHIBITION_NO);
			permission.setStatus(MyConstants.DATA_STATUS_NO);
			permissionMapper.savePermission(permission);
			map = MapTool.createMessageMap(2000, "保存成功", null);
		} catch (Exception e) {
			map = MapTool.createMessageMap(5000, "保存失败", null);
		}
		
		return map;
	}

	@Override
	public ModelAndView showPermissionWindow(Integer id) {
		
		ModelAndView model = new ModelAndView();
		if(id != null) {
			Permission permission = permissionMapper.getPermissionById(id);
			model.addObject("permission",permission);
		}
		model.setViewName("system/permission/permission_add");
		return model;
	}

	@Override
	public Map<String, Object> updateOperateByIdAndProhibition(Integer id, String prohibition) {
		Permission permission = permissionMapper.getPermissionById(id);
		Map<String,Object> map = new HashMap<String,Object>();
		if(prohibition != null || prohibition != null) {
			if(MyConstants.DATA_PROHIBITION_NO.equals(prohibition)) {
				permission.setProhibition(MyConstants.DATA_PROHIBITION_OK);
			}else if(MyConstants.DATA_PROHIBITION_OK.equals(prohibition)) {
				permission.setProhibition(MyConstants.DATA_PROHIBITION_NO);
			}
		}
		
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		permission.setMdifyTime(new Date());
		permission.setModifyUser(user.getNickName());
		
		if(permissionMapper.updatePermission(permission) == 1) {
			map = MapTool.createMessageMap(2000, "修改成功", null);
		}else {
			map = MapTool.createMessageMap(5000, "修改失败", null);
		}
		return map;
	}

	@Override
	public Map<String, Object> updatePermission(Permission permission) {
		Map<String, Object> map = new HashMap<String,Object>();
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		permission.setMdifyTime(new Date());
		permission.setModifyUser(user.getNickName());
		if(permissionMapper.updatePermission(permission) == 1) {
			map = MapTool.createMessageMap(2000, "修改成功", null);
		 }else {
			map = MapTool.createMessageMap(5000, "修改失败", null);
		 }
		 return map;
	}

	@Override
	public Map<String, Object> deletePermissionById(Integer id) {
		Map<String, Object> map = new HashMap<String,Object>();
		
		if(id != null) {
			Permission permission = permissionMapper.getPermissionById(id);
			
			User user = (User) SecurityUtils.getSubject().getPrincipal();
			
			permission.setModifyUser(user.getNickName());
			permission.setMdifyTime(new Date());
			permission.setStatus(MyConstants.DATA_STATUS_OK);
			permission.setProhibition(MyConstants.DATA_PROHIBITION_OK);
			if(permissionMapper.updatePermission(permission) == 1) {
			 map = MapTool.createMessageMap(2000, "删除成功", null);
			}else {
			 map = MapTool.createMessageMap(5000, "删除失败", null);
			}
		}
		
		return map;
	}

	@Override
	public List<Permission> listPermissionDataListByStatus() {
		try {
			List<Permission> list =  permissionMapper.listPermissionDataListByStatus();
			return list;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Map<String, Object> updatePermissionByStatusAndProhibition(Integer id) {
		Permission permission = permissionMapper.getPermissionById(id);
		Map<String,Object> map = new HashMap<String,Object>();
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		
		permission.setModifyUser(user.getNickName());
		permission.setMdifyTime(new Date());
		permission.setStatus(MyConstants.DATA_STATUS_NO);
		permission.setProhibition(MyConstants.DATA_PROHIBITION_NO);
		if(permissionMapper.updatePermission(permission) == 1) {
			map = MapTool.createMessageMap(2000, "操作成功", null);
		}else {
			map = MapTool.createMessageMap(5000, "操作失败", null);
		}
		return map;
	}

	@Override
	public Map<String, Object> deletePermissionByDB(Integer id) {
		
		Map<String,Object> map = new HashMap<String,Object>();
		
		if(permissionMapper.deletePermissionByDB(id) == 1) {
			map = MapTool.createMessageMap(2000, "删除成功", null);
		}else {
			map = MapTool.createMessageMap(5000, "删除失败", null);
		}
		
		return map;
	}

}
