package com.integrate.service.config.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.integrate.mapper.config.LevelMapper;
import com.integrate.pojo.config.Level;
import com.integrate.service.config.LevelService;

@Service
@Transactional
public class LevelServiceImpl implements LevelService {

	@Autowired
	private LevelMapper levelMapper;
	
	@Override
	public List<Level> listLevel() {
		try {
			 return levelMapper.listLevel();
		} catch (Exception e) {
			e.printStackTrace();
			 return null;
		}
	}

}
