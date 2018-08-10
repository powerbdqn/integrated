package com.integrate.controller.system;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.integrate.pojo.system.Role;
import com.integrate.service.system.RoleService;

@Controller
@RequestMapping("/role")
public class RoleController {

	@Autowired
	private RoleService roleService;
	
	@RequestMapping("/toRole.do")
	public String toRoleView() {
		return "system/role/role";
	}
	
	@RequestMapping("/toAddRoleView.do")
	public String toAddRoleView() {
		return "system/role/role_add";
	}
	
	@RequestMapping("/role_list.do")
	@ResponseBody
	public List<Role> listRoles(){
		return roleService.listRoles();
	}
}
