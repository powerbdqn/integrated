package com.integrate.service.system;

import java.util.List;
import java.util.Map;

import com.integrate.pojo.system.User;

public interface UserService {

	User findByUserName(String username);

	List<User> listUsers();

	Map<String, Object> checkUserCard(String card);
}
