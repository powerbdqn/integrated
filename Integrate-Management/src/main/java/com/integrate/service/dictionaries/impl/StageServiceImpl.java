package com.integrate.service.dictionaries.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.integrate.mapper.dictionaries.StageMapper;
import com.integrate.pojo.dictionaries.Stage;
import com.integrate.service.dictionaries.StageService;

@Service
@Transactional
public class StageServiceImpl implements StageService {

	@Autowired
	private StageMapper stageMapper;

	@Override
	public List<Stage> liststages() {
		return stageMapper.liststages();
	}

	@Override
	public Integer getStageIdByStageName(String name) {
		return stageMapper.getStageIdByStageName(name);
	}

}
