package com.integrate.controller.system;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
	
	@RequestMapping("/show.do")
	public ModelAndView showPermissionWindow(Integer id) {
		return permissionService.showPermissionWindow(id);
	}
	
	@RequestMapping("/permission_list.do")
	@ResponseBody
	public List<Permission> listPermissions(){
		return permissionService.listPermissions();
	}
	
	@RequestMapping("/permission_save.do")
	@ResponseBody
	public Map<String,Object> savePermission(Permission permission){
		return permissionService.savePermission(permission);
	}
	
	@RequestMapping("/permission_update_operate.do")
	@ResponseBody
	public Map<String,Object> updateOperateByIdAndProhibition(Integer id,String prohibition){
		return permissionService.updateOperateByIdAndProhibition(id,prohibition);
	}
	
	@RequestMapping("/permission_update.do")
	@ResponseBody
	public Map<String,Object> updatePermission(Permission permission){
		return permissionService.updatePermission(permission);
	}
	
	
	@RequestMapping("/permission_del.do")
	@ResponseBody
	public Map<String,Object> deletePermissionById(Integer id){
		return permissionService.deletePermissionById(id);
	}
	
	@RequestMapping("/permission_show_remove.do")
	public String toUpdatePermission() {
		return "system/permission/permission_update";
	}
	
	@RequestMapping("/remove_update.do")
	@ResponseBody
	public List<Permission> listPermissionDataListByStatus(){
		return permissionService.listPermissionDataListByStatus();
	}
	
	@RequestMapping("/update_permission.do")
	@ResponseBody
	public Map<String,Object> updatePermissionByStatusAndProhibition(Integer id){
		return permissionService.updatePermissionByStatusAndProhibition(id);
	}
	
	@RequestMapping("/delete_permission.do")
	@ResponseBody
	public Map<String,Object> deletePermissionByDB(Integer id){
		return permissionService.deletePermissionByDB(id);
	}
	
}
