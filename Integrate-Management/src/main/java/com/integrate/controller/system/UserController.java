package com.integrate.controller.system;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.integrate.pojo.system.User;
import com.integrate.service.system.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
    @RequestMapping("/user_login.do")
    public String login(User user,HttpSession session) {
    	
    	Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(),user.getPassword());
        try {
            subject.login(token);
            return "index";
        } catch (AuthenticationException e) {
            System.err.println("异常是:" + e.getMessage());
            return "login";
        }
    }
    
    @RequestMapping("/user/toUser.do")
    public String toUserView() {
    	return "system/user/user";
    }
    
    @RequestMapping("/user/toAddUserView.do")
    public String toADDUserView() {
    	return "system/user/user_add";
    }
    
    @RequestMapping("/user/user_list.do")
    @ResponseBody
    public List<User> listUsers(){
    	return userService.listUsers();
    }
    
    @RequestMapping("/user/check_card.do")
    @ResponseBody
    public Map<String,Object> checkUserCard(String card){
    	return userService.checkUserCard(card);
    }
    
    public static void main(String[] args) throws ParseException {
    	String a = "{\"status\":\"201\",\"msg\":\"1989-08-16\"}";
    	Map<String,Object> map = JSONArray.parseObject(a, Map.class);
    	System.err.println(map);

    	Map<String,Object> retMap = new HashMap<String,Object>();
    	Set<Entry<String,Object>> set = map.entrySet();
    	for (Entry<String, Object> entry : set) {
			String key = entry.getKey();
			Object value = map.get(key);
			System.err.println(key + ">>>" + value);
			retMap.put(key, value);
		}
    	Object value = retMap.get("msg");
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    	Date date = sdf.parse(value.toString());
    	System.out.println(date);
    	System.out.println(value.toString().replace("-", ""));
    	Object status = retMap.get("status");
    	System.err.println("202".equals(status));
	}
}
