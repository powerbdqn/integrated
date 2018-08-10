package com.integrate.service.system;

import java.util.List;

import com.integrate.pojo.system.Permission;
import com.integrate.pojo.system.User;

public interface PermissionService {

	List<Permission> findByUser(User user);

	List<Permission> listPermissions();

}
