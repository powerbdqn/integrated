package com.integrate.mapper.dictionaries;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.integrate.pojo.dictionaries.Books;

public interface BooksMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Books record);

    int insertSelective(Books record);

    Books selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Books record);

    int updateByPrimaryKey(Books record);

	List<Books> getBooksByStageId(Integer stageId);

	Books getBooksNameById(String status, Integer id);

	Integer getBooksIdByBooksName(@Param("stageId")Integer stageId,@Param("name") String name);
}