package com.integrate.mapper.dictionaries;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.integrate.pojo.dictionaries.Chapter;

public interface ChapterMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Chapter record);

    int insertSelective(Chapter record);

    Chapter selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Chapter record);

    int updateByPrimaryKey(Chapter record);

	List<Chapter> getChapterByBooksId(@Param("booksId")Integer booksId,
									  @Param("prohibition") String prohibition, 
									  @Param("status")String status);

	Integer getChapterIdByChapterName(@Param("stageId")Integer stageId, 
									  @Param("booksId")Integer booksId, 
									  @Param("name")String name);

}