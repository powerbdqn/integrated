package com.integrate.service.dictionaries;

import java.util.List;

import com.integrate.pojo.dictionaries.QuestionTypes;

public interface QuestionTypesService {

	List<QuestionTypes> listQuestionTypes();

	QuestionTypes getquestionTypesNameById(Integer questiontypesId);

}
