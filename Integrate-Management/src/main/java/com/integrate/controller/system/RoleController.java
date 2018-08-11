package com.integrate.controller.system;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
	
	
	@RequestMapping("/show.do")
	public ModelAndView showRoleWindow(Integer id) {
		return roleService.showRoleWindow(id);
	}
	
	@RequestMapping("/role_save.do")
	@ResponseBody
	public Map<String,Object> saveRole(Role role,String[] permissionIds,String menuIds){
		return roleService.saveRole(role,permissionIds,menuIds);
	}
	
	@RequestMapping("/role_update_operate.do")
	@ResponseBody
	public Map<String,Object> updateOperate(Integer id ,String prohibition){
		return roleService.updateOperate(id,prohibition);
	}
	
	@RequestMapping("/role_del.do")
	@ResponseBody
	public Map<String,Object> updateRoleByStatus(Integer id){
		return roleService.updateRoleByStatus(id);
	}
	
}
