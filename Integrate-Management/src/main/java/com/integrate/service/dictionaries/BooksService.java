package com.integrate.service.dictionaries;

import java.util.List;

import com.integrate.pojo.dictionaries.Books;

public interface BooksService {

	List<Books> getBooksByStageId(Integer stageId);

	Books getBooksNameById(Integer bookId);

	Integer getBooksIdByBooksName(Integer stageId, String name);

}
