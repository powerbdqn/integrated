package com.integrate.service.question;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.integrate.mapper.question.QuestionMapper;
import com.integrate.pojo.question.Question;

@Service
@Transactional
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QuestionMapper questionMapper;

	@Override
	public List<Question> listQuestions(Map<String, Object> queryMap) {
		return questionMapper.listQuestions(queryMap);
	}

	@Override
	public int getCountByQuestion() {
		return questionMapper.getCountByQuestion();
	}

	@Override
	public Question selectByPrimaryKey(Integer id) {
		return questionMapper.selectByPrimaryKey(id);
	}

	@Override
	public void deleQuestionById(@Param("status")String status, @Param("id")Integer id) {
		questionMapper.updateStatusById(status,id);
	}

	@Override
	public void saveQuestion(Question question) {
		questionMapper.insert(question);
	}

	@Override
	public void updateQuestion(Question question) {
		questionMapper.updateByPrimaryKey(question);
	}

	@Override
	public void saveQuestionByList(List<Question> list) {
		for (Question question : list) {
			questionMapper.insert(question);
		}
	}

}
