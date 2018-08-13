package com.integrate.controller.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.integrate.pojo.config.Identity;
import com.integrate.service.config.IdentityService;

@Controller
@RequestMapping("/identity")
public class IdentityController {

	@Autowired
	private IdentityService indentityService;
	
	@RequestMapping("/identity_list.do")
	@ResponseBody
	public List<Identity> listIdentity(){
		return indentityService.listIdentity();
	}
}
