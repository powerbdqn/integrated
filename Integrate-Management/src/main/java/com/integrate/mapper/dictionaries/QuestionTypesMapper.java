package com.integrate.mapper.dictionaries;

import java.util.List;

import com.integrate.pojo.dictionaries.QuestionTypes;


public interface QuestionTypesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QuestionTypes record);

    int insertSelective(QuestionTypes record);

    QuestionTypes selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(QuestionTypes record);

    int updateByPrimaryKey(QuestionTypes record);

	List<QuestionTypes> listQuestionTypes();
}