package com.integrate.service.system;

import java.util.List;
import java.util.Map;

import org.springframework.web.servlet.ModelAndView;

import com.integrate.pojo.system.Role;
import com.integrate.pojo.system.User;

public interface RoleService {

	List<Role> findByUser(User user);

	List<Role> listRoles();

	ModelAndView showRoleWindow(Integer id);

	Map<String, Object> saveRole(Role role, String[] permissionIds, String menuIds);

	Map<String, Object> updateOperate(Integer id, String prohibition);

	Map<String, Object> updateRoleByStatus(Integer id);

}
