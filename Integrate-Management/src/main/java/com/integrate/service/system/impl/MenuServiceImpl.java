package com.integrate.service.system.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.integrate.mapper.system.MenuMapper;
import com.integrate.pojo.system.Menu;
import com.integrate.service.system.MenuService;
import com.integrate.tool.MyConstants;

@Service
@Transactional
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuMapper menuMapper;

	@Override
	public List<Menu> listMenus(Integer page, Integer rows) {
		return menuMapper.listMenus(page,rows);
	}

	@Override
	public Set<Menu> getMenusByPid(Integer pid) {
		return menuMapper.getMenusByPid(pid);
	}

	@Override
	public List<Menu> findMenusByPid(Integer pid) {
		return menuMapper.findMenusByPid(null);
	}

	@Override
	public Set<Menu> findMenuByPid(Integer id) {
		return menuMapper.findMenuByPid(id);
	}

	@Override
	public List<Menu> getMenusByUserId(Integer id) {
		return menuMapper.getMenusByUserId(id);
	}

	@Override
	public String getParentMenuNameByPid(Integer pid) {
		return menuMapper.getParentMenuNameByPid(pid);
	}

	@Override
	public void saveMenu(Menu menu) {
		menuMapper.saveMenu(menu);
	}

	@Override
	public List<Menu> findParentMenusByPid() {
		return menuMapper.findParentMenusByPid();
	}

	@Override
	public Menu findMenuById(Integer id) {
		return menuMapper.findMenuById(id);
	}

	@Override
	public void updateMenu(Menu menu) {
		menuMapper.updateMenu(menu);
	}

	@Override
	public List<Menu> listMenuByStatus() {
		return menuMapper.listMenuByStatus();
	}

	@Override
	public void updateMenuStatusAndProhibition(Map<String, Object> map) {
		menuMapper.updateMenuStatusAndProhibition(map);
	}

	@Override
	public void deleteMenuById(Map<String, Object> map) {
		menuMapper.deleteMenuById(map);
	}

	@Override
	public int getCount() {
		return menuMapper.getCount();
	}

	@Override
	public List<Menu> listMenusByStatusAndProhibition() {
		return menuMapper.listMenusByStatusAndProhibition(MyConstants.DATA_STATUS_NO,MyConstants.DATA_PROHIBITION_NO);
	}
	
}
