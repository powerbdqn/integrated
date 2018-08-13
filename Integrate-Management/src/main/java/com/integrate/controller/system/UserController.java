package com.integrate.controller.system;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
    
    @RequestMapping("/user/user_save.do")
    @ResponseBody
    public Map<String,Object> saveUser(User user,String[] roleIds){
    	return userService.saveUser(user,roleIds);
    	
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
    
 
    @RequestMapping("/user/del_user.do")
    @ResponseBody
    public Map<String,Object> delUserById(Integer id){
    	return userService.delUserById(id);
    }
    
    
    @RequestMapping("/user/operate_user.do")
    @ResponseBody
    public Map<String,Object> operateUserById(Integer id ,String prohibition){
    	return userService.operateUserById(id,prohibition);
    }
    
    @RequestMapping("/user/update_user.do")
    public ModelAndView updateUserbyId(Integer id) {
    	return userService.updateUserbyId(id);
    }
}
