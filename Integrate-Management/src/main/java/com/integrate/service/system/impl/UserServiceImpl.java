package com.integrate.service.system.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import com.integrate.mapper.system.RoleMapper;
import com.integrate.mapper.system.UserAndRoleMapper;
import com.integrate.mapper.system.UserMapper;
import com.integrate.pojo.system.Role;
import com.integrate.pojo.system.User;
import com.integrate.pojo.system.UserAndRoleKey;
import com.integrate.service.system.UserService;
import com.integrate.tool.CheckCard;
import com.integrate.tool.MapTool;
import com.integrate.tool.MyConstants;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private RoleMapper roleMapper;

	@Autowired
	private UserAndRoleMapper userAndRoleMapper;

	@Override
	public User findByUserName(String username) {
		return userMapper.findByUsername(username);
	}

	@Override
	public List<User> listUsers() {
		return userMapper.listUsers();
	}

	@Override
	public Map<String, Object> checkUserCard(String cord) {

		Map<String, Object> map = new HashMap<String, Object>();

		try {
			if (cord == null || cord.length() <= 0) {
				map = MapTool.createMessageMap(5000, "身份证号码非法", null);
				return map;
			} else {
				map = CheckCard.registerParam(cord);
			}
		} catch (Exception e) {
			e.printStackTrace();
			map = MapTool.createMessageMap(5000, "系统异常,请稍后再试", null);
		}
		return map;
	}

	@Override
	public Map<String, Object> saveUser(User user, String[] roleIds) {
		User currentUser = (User) SecurityUtils.getSubject().getPrincipal();
		Map<String, Object> map = new HashMap<String, Object>();
		if(currentUser == null) {
			map = MapTool.createMessageMap(5000, "您已失去登录状态,请重新登录", null);
			return map;
		}else {
			if(!"1".equals(currentUser.getIdentity())) {
				map = MapTool.createMessageMap(5000, "您的身份非法,请重新登录后获取最新权限", null);
				return map;
			}
		}
		
		user.setModifyTime(new Date());
		user.setModifyUser(currentUser.getNickName());
		try {
			String[] arr = {};

			if (roleIds == null || roleIds.length <= 0) { // 如果等于null或空, 则把空数组赋值给roleIds数组,防止空指针
				roleIds = arr;
			}

			if (user.getId() == null && roleIds != null && roleIds.length > 0) {// 说明是新增操作
				
				user.setCreateTime(new Date());
				user.setCreateUser(currentUser.getNickName());
				user.setStatus(MyConstants.DATA_STATUS_NO);
				user.setProhibition(MyConstants.DATA_PROHIBITION_NO);
				userMapper.insertUser(user);
				Integer userId = user.getId();
				for (String ids : roleIds) {
					if (ids != null) {
						Integer roleId = Integer.parseInt(ids);
						UserAndRoleKey key = new UserAndRoleKey();
						key.setRoleId(roleId);
						key.setUserId(userId);
						userAndRoleMapper.insert(key);
					}
				}
			} else {// 说明是修改操作
				userMapper.updateUserByPrimaryKey(user);// 修改该表中的其他字段
				Integer userId = user.getId();
				List<Role> roles = roleMapper.getRoleListByUserId(userId);// 先查询出原来有什么角色
				if (roleIds.length > 0 && roles != null) {// 说明要修改该用户的角色或覆盖该用户的角色再添加新的,因为我们不是根据表主键操作,而是通过外键操作.所以
																	// 得通过角色id先删除以前的连接表数据,再添加新的连接表数据
					// 说明用户以前有角色,那么先删除以前的角色,再添加现在的角色
					for (Role role : roles) {// 取出role的id
						Integer roleId = role.getId();
						// 循环删除连接表数据
						userAndRoleMapper.deleteByUserIdAndRoleId(userId, roleId);
					}

					for (String ids : roleIds) {
						if (ids != null) {
							Integer roleId = Integer.parseInt(ids);
							UserAndRoleKey key = new UserAndRoleKey();
							key.setRoleId(roleId);
							key.setUserId(userId);
							userAndRoleMapper.insert(key);
						}
					}
				} else if (roleIds.length > 0 && roles == null) {
					// 说明用户想增加角色   直接添加
					for (String ids : roleIds) {
						if (ids != null) {
							Integer roleId = Integer.parseInt(ids);
							UserAndRoleKey key = new UserAndRoleKey();
							key.setRoleId(roleId);
							key.setUserId(userId);
							userAndRoleMapper.insert(key);
						}
					}
					
				} else if (roleIds.length == 0 && roles == null) {// 说明用户只增加除角色的其他字段
					user.setCreateTime(new Date());
					user.setCreateUser(currentUser.getNickName());
					user.setStatus(MyConstants.DATA_STATUS_NO);
					user.setProhibition(MyConstants.DATA_PROHIBITION_NO);
					userMapper.insertUser(user);
				} else if (roleIds.length == 0 && roles != null) {// 说明要清空该用户的所有角色
					userAndRoleMapper.deleteByUserId(userId);
					userMapper.updateUserByPrimaryKey(user);
				} 
			}
			map = MapTool.createMessageMap(2000, "保存成功", null);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			map = MapTool.createMessageMap(5000, "保存失败", null);
		}
		
		return map;
	}

	@Override
	public Map<String, Object> delUserById(Integer id) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			User user = userMapper.selectByPrimaryKey(id);
			User currentUser = (User) SecurityUtils.getSubject().getPrincipal();
			user.setModifyTime(new Date());
			user.setModifyUser(currentUser.getNickName());
			user.setStatus(MyConstants.DATA_STATUS_OK);
			user.setProhibition(MyConstants.DATA_PROHIBITION_OK);
			userMapper.updateUserByPrimaryKey(user);
			map = MapTool.createMessageMap(2000, "操作成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			map = MapTool.createMessageMap(5000, "操作失败", null);
		}
		return map;
	}
	
	@Override
	public Map<String, Object> operateUserById(Integer id, String prohibition) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			if(id != null && prohibition != null) {
				User currentUser = (User) SecurityUtils.getSubject().getPrincipal();
				User user = userMapper.selectByPrimaryKey(id);
				user.setModifyTime(new Date());
				user.setModifyUser(currentUser.getNickName());
				if(MyConstants.DATA_PROHIBITION_NO.equals(prohibition)) {
					user.setProhibition(MyConstants.DATA_PROHIBITION_OK);
				}else if(MyConstants.DATA_PROHIBITION_OK.equals(prohibition)) {
					user.setProhibition(MyConstants.DATA_PROHIBITION_NO);
				}
				userMapper.updateUserByPrimaryKey(user);
			}
			map = MapTool.createMessageMap(2000, "删除成功", null);
		} catch (Exception e) {
			map = MapTool.createMessageMap(5000, "删除失败", null);
			e.printStackTrace();
		}
		return map;
	}

	@Override
	public ModelAndView updateUserbyId(Integer id) {
		ModelAndView model = new ModelAndView();
		if(id != null) {
			User user = userMapper.selectByPrimaryKey(id);
			model.addObject("user", user);
		}
		model.setViewName("system/user/user_update");
		return model;
	}
	public static void main(String[] args) throws ParseException {
		String str = "8-13-2018";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse(str);
		Date date1 = new Date();
		System.err.println(date);
		String format = sdf.format(date1);
		System.out.println(format);
	}
}
