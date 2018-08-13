package com.integrate.controller.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.integrate.pojo.config.Level;
import com.integrate.service.config.LevelService;

@Controller
@RequestMapping("/level")
public class LevelController {

	@Autowired
	private LevelService levelService;
	
	@RequestMapping("/level_list.do")
	@ResponseBody
	public	List<Level> listLevel(){
		return levelService.listLevel();
	}
}
