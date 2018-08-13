package com.integrate.service.system;

import java.util.List;
import java.util.Map;

import org.springframework.web.servlet.ModelAndView;

import com.integrate.pojo.system.User;

public interface UserService {

	User findByUserName(String username);

	List<User> listUsers();

	Map<String, Object> checkUserCard(String card);

	Map<String, Object> saveUser(User user, String[] roleIds);

	Map<String, Object> delUserById(Integer id);

	Map<String, Object> operateUserById(Integer id, String prohibition);

	ModelAndView updateUserbyId(Integer id);
}
