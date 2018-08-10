package com.integrate.controller.system;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.integrate.pojo.system.Permission;
import com.integrate.service.system.PermissionService;

@Controller
@RequestMapping("/permission")
public class PermissionController {

	@Autowired
	private PermissionService permissionService;
	
	
	@RequestMapping("/toPers.do")
	public String toPermissionView() {
		return "system/permission/permission";
	}
	
	@RequestMapping("/toAddPermissionView.do")
	public String toAddPermissionView() {
		return "system/permission/permission_add";
	}
	
	@RequestMapping("/permission_list.do")
	@ResponseBody
	public List<Permission> listPermissions(){
		return permissionService.listPermissions();
	}	
}
