package com.integrate.service.dictionaries.impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.integrate.mapper.dictionaries.BooksMapper;
import com.integrate.pojo.dictionaries.Books;
import com.integrate.service.dictionaries.BooksService;

@Service
@Transactional
public class BooksServiceImpl implements BooksService {

	@Autowired
	private BooksMapper booksMapper;

	@Override
	public List<Books> getBooksByStageId(Integer stageId) {
		return booksMapper.getBooksByStageId(stageId);
	}

	@Override
	public Books getBooksNameById(Integer id) {
		return booksMapper.selectByPrimaryKey(id);
	}

	@Override
	public Integer getBooksIdByBooksName(Integer stageId,String name) {
		return booksMapper.getBooksIdByBooksName(stageId,name);
	}
}
