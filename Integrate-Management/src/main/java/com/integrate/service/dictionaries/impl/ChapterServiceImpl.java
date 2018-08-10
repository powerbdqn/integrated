package com.integrate.service.dictionaries.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.integrate.mapper.dictionaries.ChapterMapper;
import com.integrate.pojo.dictionaries.Chapter;
import com.integrate.service.dictionaries.ChapterService;

@Service
@Transactional
public class ChapterServiceImpl implements ChapterService {

	@Autowired
	private ChapterMapper chapterMapper;

	@Override
	public List<Chapter> getChapterByBooksId(Integer booksId, String prohibition, String status) {
		return chapterMapper.getChapterByBooksId(booksId,prohibition,status);
	}

	@Override
	public Chapter getChapterNameById(Integer id) {
		return chapterMapper.selectByPrimaryKey(id);
	}

	@Override
	public Integer getChapterIdByChapterName(Integer stageId, Integer booksId, String name) {
		return chapterMapper.getChapterIdByChapterName(stageId,booksId,name);
	}
	
}
