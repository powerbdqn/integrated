package com.integrate.controller.dictionaries;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.integrate.pojo.dictionaries.Books;
import com.integrate.service.dictionaries.BooksService;

@Controller
@RequestMapping("/books")
public class BooksController {
	
	@Autowired
	private BooksService booksService;
	
	@RequestMapping("/getBooksByStageId.do")
	@ResponseBody
	public List<Books> getBooksByStageId(Integer stageId){
		
		return booksService.getBooksByStageId(stageId);
	}
	
}
