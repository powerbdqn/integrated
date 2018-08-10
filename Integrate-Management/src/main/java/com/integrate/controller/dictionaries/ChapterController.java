package com.integrate.controller.dictionaries;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.integrate.pojo.dictionaries.Chapter;
import com.integrate.service.dictionaries.ChapterService;
import com.integrate.tool.MyConstants;

@Controller
@RequestMapping("/chapter")
public class ChapterController {

	@Autowired
	private ChapterService chapterService;
	
	@RequestMapping("/getChapterByBooksId.do")
	@ResponseBody
	public List<Chapter> getChapterByBooksId(Integer booksId){
		return chapterService.getChapterByBooksId(booksId,MyConstants.DATA_PROHIBITION_NO,MyConstants.DATA_STATUS_NO);
	}
}
