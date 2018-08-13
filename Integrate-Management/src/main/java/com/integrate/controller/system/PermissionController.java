package com.integrate.controller.system;

import java.util.ArrayList;
import java.util.HashMap;
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
	
	@RequestMapping("/test.do")
	@ResponseBody
	public List<Map<String,Object>> list(){
		
		List<Map<String,Object>> list = new ArrayList<>();
		
		Map<String,Object> map = new HashMap<String,Object>();
		int arr[]= {1,5,3,14,5,6,17,8,9,10,11,12}; 
		map.put("data", arr);
		map.put("name", "Y2T05班");
		
		Map<String,Object> map1 = new HashMap<String,Object>();
		int arr1[]= {1,2,3,14,5,6,17,8,9,10,11,12}; 
		map1.put("data", arr1);
		map1.put("name", "Y2T06班");
		Map<String,Object> map2 = new HashMap<String,Object>();
		int arr2[]= {1,2,3,14,5,6,17,8,91,10,5,12}; 
		map2.put("data", arr2);
		map2.put("name", "Y2T07班");
		Map<String,Object> map3 = new HashMap<String,Object>();
		int arr3[]= {1,2,3,14,5,6,17,18,9,10,12,1}; 
		map3.put("data", arr3);
		map3.put("name", "Y2T08班");
		list.add(map);
		list.add(map1);
		list.add(map2);
		list.add(map3);
		return list;
	}
	
	
	@RequestMapping("/toPers.do")
	public String toPermissionView() {
		return "system/permission/permission";
	}
	
	@RequestMapping("/show.do")
	public ModelAndView showPermissionWindow(Integer id) {
		return permissionService.showPermissionWindow(id);
	}
	
	
	@RequestMapping("/findPermissionByRoleId.do")
	@ResponseBody
	public List<Permission> findPermissionByRoleId(Integer id){
		return permissionService.findPermissionByRoleId(id);
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
