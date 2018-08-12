package com.integrate.service.system;

import java.util.List;
import java.util.Map;

import org.springframework.web.servlet.ModelAndView;

import com.integrate.pojo.system.Permission;
import com.integrate.pojo.system.User;

public interface PermissionService {

	List<Permission> findByUser(User user);

	List<Permission> listPermissions();

	Map<String,Object> savePermission(Permission permission);

	ModelAndView showPermissionWindow(Integer id);

	Map<String, Object> updateOperateByIdAndProhibition(Integer id, String prohibition);

	Map<String, Object> updatePermission(Permission permission);

	Map<String, Object> deletePermissionById(Integer id);

	List<Permission> listPermissionDataListByStatus();

	Map<String, Object> updatePermissionByStatusAndProhibition(Integer id);

	Map<String, Object> deletePermissionByDB(Integer id);

	List<Permission> findPermissionByRoleId(Integer id);

}
