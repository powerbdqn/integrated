package com.integrate.mapper.question;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.integrate.pojo.question.Question;

public interface QuestionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Question record);

    int insertSelective(Question record);

    Question selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Question record);

    int updateByPrimaryKey(Question record);

	List<Question> listQuestions(Map<String, Object> queryMap);

	int getCountByQuestion();

	void updateStatusById(@Param("status")String status, @Param("id")Integer id);
	
}