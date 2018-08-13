package com.integrate.mapper.config;

import java.util.List;

import com.integrate.pojo.config.Level;

public interface LevelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Level record);

    int insertSelective(Level record);

    Level selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Level record);

    int updateByPrimaryKey(Level record);

	List<Level> listLevel();

}