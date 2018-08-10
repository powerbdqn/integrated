package com.integrate.controller.dictionaries;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.integrate.pojo.dictionaries.Stage;
import com.integrate.service.dictionaries.StageService;

@Controller
@RequestMapping("/stage")
public class StageController {

	@Autowired
	private StageService stageService;
	
	@RequestMapping("/liststages.do")
	@ResponseBody
	public List<Stage> liststages(){
		return stageService.liststages();
	}
}
