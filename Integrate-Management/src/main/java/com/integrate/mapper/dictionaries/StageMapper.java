package com.integrate.mapper.dictionaries;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.integrate.pojo.dictionaries.Stage;

public interface StageMapper {
	
    int deleteByPrimaryKey(Integer id);

    int insert(Stage record);

    int insertSelective(Stage record);

    Stage selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Stage record);

    int updateByPrimaryKey(Stage record);

	List<Stage> liststages();

	Integer getStageIdByStageName(@Param("name")String name);
}