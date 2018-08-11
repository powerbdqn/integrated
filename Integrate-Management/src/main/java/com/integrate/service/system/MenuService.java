package com.integrate.service.system;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.integrate.pojo.system.Menu;

public interface MenuService {

	List<Menu> listMenus(Integer page, Integer rows);

	Set<Menu> getMenusByPid(Integer pid);

	List<Menu> findMenusByPid(Integer pid);

	Set<Menu> findMenuByPid(Integer id);

	List<Menu> getMenusByUserId(Integer id);

	String getParentMenuNameByPid(Integer pid);

	void saveMenu(Menu menu);

	List<Menu> findParentMenusByPid();

	Menu findMenuById(Integer id);

	void updateMenu(Menu menu);

	List<Menu> listMenuByStatus();

	void updateMenuStatusAndProhibition(Map<String, Object> map);

	void deleteMenuById(Map<String, Object> map);

	int getCount();

	List<Menu> listMenusByStatusAndProhibition();


}
