package com.integrate.service.system;

import java.util.List;

import com.integrate.pojo.system.Role;
import com.integrate.pojo.system.User;

public interface RoleService {

	List<Role> findByUser(User user);

	List<Role> listRoles();

}
