package com.integrate.controller.dictionaries;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.integrate.pojo.dictionaries.QuestionTypes;
import com.integrate.service.dictionaries.QuestionTypesService;

@Controller
@RequestMapping("/questionTypes")
public class QuestionTypesController {
	
	@Autowired
	private QuestionTypesService questionTypesService;
	
	@RequestMapping("/listQuestionTypes.do")
	@ResponseBody
	public List<QuestionTypes> listQuestionTypes(){
		return questionTypesService.listQuestionTypes();
	}
}
