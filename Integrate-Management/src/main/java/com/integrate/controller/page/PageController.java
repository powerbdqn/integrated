package com.integrate.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping("/toLogin.do")
    public String toLoginView() {
        return "login";
    }
    
    @RequestMapping("/toUser.do")
    public String toUserView() {
        return "userinfo";
    }
    
    @RequestMapping("/toMenu.do")
    public String toMenuView() {
        return "menu";
    }
    
    @RequestMapping("/toPer.do")
    public String toPerView() {
        return "permission";
    }
    
    @RequestMapping("/toRole.do")
    public String toRoleView() {
        return "role";
    }
    
    @RequestMapping("/toAddRole.do")
    public String toAddRoleView() {
        return "role_add";
    }
    
    @RequestMapping("/to_addMenu.do")
    public String toAddMenuView() {
        return "menu_add";
    }
    @RequestMapping("/to_permission_add.do")
    public String toPermissionView() {
        return "permission_add";
    }
    
    @RequestMapping("/toMain.do")
    public String toMainView() {
    	return "main";
    }
    
    @RequestMapping("/toQues.do")
    public String toQuestionView() {
    	return "question/question";
    }
    
    
    @RequestMapping("/toProto.do")
    public String toProtoView() {
    	return "question/question_proto";
    }
}
