package com.integrate.service.system.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.integrate.mapper.system.UserMapper;
import com.integrate.pojo.VO.RegisterUser;
import com.integrate.pojo.system.User;
import com.integrate.service.system.UserService;
import com.integrate.tool.CheckCard;
import com.integrate.tool.HttpUtil;
import com.integrate.tool.MapTool;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
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
		
		Map<String, Object> map = new HashMap<String,Object>();
		
		try {
			if(cord == null || cord.length() <= 0) {
				map = MapTool.createMessageMap(5000, "身份证号码非法", null);
				return map;
			}else {
				 map = CheckCard.registerParam(cord);
			}
		} catch (Exception e) {
			e.printStackTrace();
			map = MapTool.createMessageMap(5000, "系统异常,请稍后再试", null);
		}
    	return map;
	}

}
