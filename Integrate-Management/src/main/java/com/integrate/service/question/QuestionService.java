package com.integrate.service.question;

import java.util.List;
import java.util.Map;

import com.integrate.pojo.question.Question;

public interface QuestionService {

	List<Question> listQuestions(Map<String, Object> queryMap);

	int getCountByQuestion();

	Question selectByPrimaryKey(Integer id);

	void deleQuestionById(String status, Integer id);

	void saveQuestion(Question question);

	void updateQuestion(Question question);

	void saveQuestionByList(List<Question> list);

}
