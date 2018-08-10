package com.integrate.service.dictionaries;

import java.util.List;

import com.integrate.pojo.dictionaries.Chapter;

public interface ChapterService {

	List<Chapter> getChapterByBooksId(Integer booksId, String prohibition, String status);

	Chapter getChapterNameById(Integer id);

	Integer getChapterIdByChapterName(Integer stageId, Integer booksId, String name);

}
