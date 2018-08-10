package com.integrate.controller.system;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.integrate.pojo.VO.Result;
import com.integrate.pojo.system.Menu;
import com.integrate.pojo.system.User;
import com.integrate.service.system.MenuService;
import com.integrate.tool.MyConstants;
/**
 * 
* @ClassName: MenuController 
* @Description:  菜单控制层
* @author 韩志彬
* @date 2018年8月10日 下午6:46:08 
*
 */
@Controller
public class MenuController {

	@Autowired
	private MenuService menuService;

	/**
	 * 
	* @Title: getMenuListByUser 
	* @Description:  获取菜单导航数据
	* @author 韩志彬   
	* @date 2018年8月10日 下午6:46:23 
	* @version V1.0 
	* @return
	 */
	@RequestMapping("/menu_showmenu.do")
	@ResponseBody
	public List<Result> getMenuListByUser() {
		
		List<Result> list = new ArrayList<>();
		Subject subject = SecurityUtils.getSubject();
		User user = (User) subject.getPrincipal();
		if(user == null) {
			return null;
		}
		List<Menu> menus = new ArrayList<Menu>();// 获取菜单集合
		Set<Menu> set = new HashSet<Menu>();
		if ("admin".equals(user.getUsername())) {
			List<Menu> parentMenus = menuService.findMenusByPid(null);
			for (Menu menu : parentMenus) {
				Set<Menu> childSet = menuService.findMenuByPid(menu.getId());
				Result result = new Result();
				result.setTitle(menu.getTitle());
				result.setIcon("");
				result.setSpread(false);
				result.setChildren(childSet);
				list.add(result);
			}
		} else {
			menus = menuService.getMenusByUserId(user.getId());
			if (menus != null) {
				for (Menu menu : menus) {
					Result result = new Result();
					if (menu.getPid() != null) {
						// 说明这是二级菜单
						set.add(menu);
						String parentNname = menuService.getParentMenuNameByPid(menu.getPid());
						System.err.println("父节点:" + parentNname);
						result.setTitle(parentNname);
					} else {
						result.setTitle(menu.getTitle());
						set.add(menu);
					}
					result.setChildren(set);
					result.setIcon("");
					result.setSpread(false);
					list.add(result);
				}
			}
		}
		return list;
	}

	/**跳转菜单列表页面*/
	@RequestMapping("/menu/toMenu.do")
	public String toMenuView() {
		return "system/menu/menu";
	}

	/**跳转添加菜单表单页面*/
	@RequestMapping("/menu/show.do")
	@ResponseBody
	public ModelAndView toAddMenuView(Integer id) {
		ModelAndView model = new ModelAndView();
		if(id != null) {
			Menu menu = menuService.findMenuById(id);
			
			model.addObject("menu",menu);
		}
		model.setViewName("system/menu/menu_add");
		return model;
	}

	
/*	@RequestMapping("/menu/show_menu.do")
	@ResponseBody
	public ModelAndView toAddMenuView(Integer id) {
		
		List<Menu> list = new ArrayList<>();
		if(id != null) {
			Menu menu = menuService.findMenuById(id);
			list.add(menu);
		}
		return list;
	}*/
	/**
	 * 
	* @Title: listMenus 
	* @Description:  分页查询所有未禁用 未逻辑删除的菜单数据集合
	* @author 韩志彬   
	* @date 2018年8月10日 下午6:47:43 
	* @version V1.0 
	* @return
	 */
	@RequestMapping("/menu/menu_list.do")
	@ResponseBody
	public Map<String,Object> listMenus(Integer page ,Integer rows) {
	
		Map<String,Object> map = new HashMap<String,Object>();
		
		 try {
			List<Menu> list =  menuService.listMenus((page-1) * rows,rows);
			 
			 
			 map.put("total", menuService.getCount());
			 map.put("rows", list);
			 map.put("msg", "数据请求成功");
			 return map;
		} catch (Exception e) {
			map.put("msg","数据请求异常,请联系管理员");
		}
		 return map;
	}

	/**
	 * 
	* @Title: findParentMenusByPid 
	* @Description:  获得父节点数据 用于添加菜单时的下拉列表回显
	* @author 韩志彬   
	* @date 2018年8月10日 下午6:48:08 
	* @version V1.0 
	* @return
	 */
	@RequestMapping("/menu/parent_menu_list.do")
	@ResponseBody
	public List<Menu> findParentMenusByPid() {
		return menuService.findParentMenusByPid();
	}

	/**
	 * 
	* @Title: saveMenu 
	* @Description:  保存菜单数据
	* @author 韩志彬   
	* @date 2018年8月10日 下午6:48:55 
	* @version V1.0 
	* @param menu
	* @return
	 */
	@RequestMapping("/menu/menu_save.do")
	@ResponseBody
	public Map<String, Object> saveMenu(Menu menu) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		User user = (User) SecurityUtils.getSubject().getPrincipal();
			if(user == null) {
				map.put("msg", "数据请求异常");
				map.put("status", false);
				return map;
			}else {
				try {
					menu.setCreateTime(new Date());
					menu.setCreateUser(user.getNickName());
					menu.setModifyUser(user.getNickName());
					menu.setMdifyTime(new Date());
					menu.setProhibition(MyConstants.DATA_PROHIBITION_NO);
					menu.setPid(menu.getpId());
					menu.setStatus(MyConstants.DATA_STATUS_NO);
					menuService.saveMenu(menu);
					map.put("msg", "保存成功");
				} catch (Exception e) {
					map.put("msg", "保存失败");
					e.printStackTrace();
				}
			}
		return map;
	}

	/**
	 * 
	* @Title: delMenuById 
	* @Description:  逻辑删除菜单数据
	* @author 韩志彬   
	* @date 2018年8月10日 下午6:49:10 
	* @version V1.0 
	* @param id
	* @return
	 */
	@RequestMapping("/menu/menu_del.do")
	@ResponseBody
	public Map<String, Object> delMenuById(Integer id) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		if (user == null) {
			map.put("msg", "数据请求异常");
			map.put("status", false);
			return map;
		} else {
			if (id == null) {
				map.put("msg", "数据请求异常");
				map.put("status", false);
				return map;
			}

			try {
				Menu menu = menuService.findMenuById(id);
				menu.setStatus(MyConstants.DATA_STATUS_OK);
				menu.setProhibition(MyConstants.DATA_PROHIBITION_OK);
				menu.setModifyUser(user.getNickName());
				menu.setMdifyTime(new Date());
				menuService.updateMenu(menu);
				map.put("msg", "删除成功");
				map.put("status", true);
			} catch (Exception e) {
				e.printStackTrace();
				map.put("msg", "删除失败");
				map.put("status", false);
			}
		}
		
		return map;
	}

	/**
	 * 
	* @Title: updateMenuOperateById 
	* @Description:  启用/禁用功能实现
	* @author 韩志彬   
	* @date 2018年8月10日 下午6:49:26 
	* @version V1.0 
	* @param id
	* @param prohibition
	* @return
	 */
	@RequestMapping("/menu/menu_update_operate.do")
	@ResponseBody
	public Map<String, Object> updateMenuOperateById(Integer id, String prohibition) {
		Map<String, Object> map = new HashMap<String, Object>();

		User user = (User) SecurityUtils.getSubject().getPrincipal();
		if (user == null) {
			map.put("msg", "用户数据异常");
			map.put("status", false);
			return map;
		} else {
			if (id == null || prohibition == null) {
				map.put("msg", "数据请求异常");
				map.put("status", false);
				return map;
			}
			
			try {
				Menu menu = menuService.findMenuById(id);
				if (MyConstants.DATA_PROHIBITION_OK.equals(prohibition)) {
					menu.setProhibition(MyConstants.DATA_PROHIBITION_NO);
				} else if (MyConstants.DATA_PROHIBITION_NO.equals(prohibition)) {
					menu.setProhibition(MyConstants.DATA_PROHIBITION_OK);
				}
				menu.setModifyUser(user.getNickName());
				menu.setMdifyTime(new Date());
				menuService.updateMenu(menu);
				map.put("msg", "修改成功");
				map.put("status", true);
			} catch (Exception e) {
				e.printStackTrace();
				map.put("msg", "修改失败");
				map.put("status", false);
			}
		}
		return map;
	}
	
	/**跳转已被逻辑删除的页面*/
	@RequestMapping("/menu/menu_show_remove.do")
	public String toUpdateMenu() {
		return "system/menu/menu_update";
	}
	
	/**
	 * 
	* @Title: listMenuByStatus 
	* @Description:  查询已被逻辑删除的菜单数据列表
	* @author 韩志彬   
	* @date 2018年8月10日 下午6:50:09 
	* @version V1.0 
	* @return
	 */
	@RequestMapping("/menu/remove_update.do")
	@ResponseBody
	public List<Menu> listMenuByStatus(){
		return menuService.listMenuByStatus();
	}
	
	/**
	 * 
	* @Title: updateMenuStatusAndProhibition 
	* @Description:  把逻辑删除的数据恢复到未禁用未被逻辑删除的状态.
	* @author 韩志彬   
	* @date 2018年8月10日 下午6:50:23 
	* @version V1.0 
	* @param id
	* @return
	 */
	@RequestMapping("/menu/update_all.do")
	@ResponseBody
	public Map<String,Object> updateMenuStatusAndProhibition(Integer id){
		Map<String,Object> retMap = new HashMap<String,Object>();
		try {
			User user = (User) SecurityUtils.getSubject().getPrincipal();
			
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("modifyUser", user.getNickName());
			map.put("mdifyTime", new Date());
			map.put("status", MyConstants.DATA_STATUS_NO);
			map.put("prohibition", MyConstants.DATA_PROHIBITION_NO);
			map.put("id", id);
			menuService.updateMenuStatusAndProhibition(map);
			retMap.put("msg", "修改成功");
		} catch (Exception e) {
			retMap.put("msg", "修改失败");
			e.printStackTrace();
		}
		return retMap;
	}
	
	/**
	 * 
	* @Title: deleteMenuById 
	* @Description:  物理删除菜单数据
	* @author 韩志彬   
	* @date 2018年8月10日 下午6:51:11 
	* @version V1.0 
	* @param id
	* @return
	 */
	@RequestMapping("/menu/deleteMenu.do")
	@ResponseBody
	public Map<String,Object> deleteMenuById(Integer id){
		Map<String,Object> retMap = new HashMap<String,Object>();
		try {
			User user = (User) SecurityUtils.getSubject().getPrincipal();
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("modifyUser", user.getNickName());
			map.put("mdifyTime", new Date());
			map.put("id", id);
			menuService.deleteMenuById(map);
			retMap.put("msg", "删除成功");
		} catch (Exception e) {
			retMap.put("msg", "删除失败");
			e.printStackTrace();
		}
		return retMap;
	}
}
