package com.integrate.service.dictionaries.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.integrate.mapper.dictionaries.QuestionTypesMapper;
import com.integrate.pojo.dictionaries.QuestionTypes;
import com.integrate.service.dictionaries.QuestionTypesService;

@Service
@Transactional
public class QuestionTypesServiceImpl implements QuestionTypesService {
	
	@Autowired
	private QuestionTypesMapper questionTypesMapper;
	
	@Override
	public List<QuestionTypes> listQuestionTypes() {
		return questionTypesMapper.listQuestionTypes();
	}

	@Override
	public QuestionTypes getquestionTypesNameById(Integer id) {
		return questionTypesMapper.selectByPrimaryKey(id);
	}

}
