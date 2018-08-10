package com.integrate.controller.question;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.integrate.pojo.VO.ReturnMap;
import com.integrate.pojo.dictionaries.Books;
import com.integrate.pojo.dictionaries.Chapter;
import com.integrate.pojo.dictionaries.QuestionTypes;
import com.integrate.pojo.question.Question;
import com.integrate.pojo.system.User;
import com.integrate.service.dictionaries.BooksService;
import com.integrate.service.dictionaries.ChapterService;
import com.integrate.service.dictionaries.QuestionTypesService;
import com.integrate.service.dictionaries.StageService;
import com.integrate.service.question.QuestionService;
import com.integrate.tool.MyConstants;

/**
 * 
* @ClassName: QuestionController 
* @Description:  试题控制器层
* @author 韩志彬
* @date 2018年8月6日 上午7:57:57 
 */
@Controller
@RequestMapping("/question")
public class QuestionController {
	
	@Autowired
	private QuestionService questionService;

	@Autowired
	private BooksService booksService;
	
	@Autowired
	private StageService stageService;
	
	@Autowired
	private ChapterService chapterService; 
	
	@Autowired
	private QuestionTypesService questionTypesService;
	
	/**跳转iframe页面*/
	@RequestMapping("/show.do")
	public String show() {
		return "question/question_show";
	}
	
	/**
	 * 
	* @Title: listQuestions 
	* @Description:  查询所有未被逻辑删除的试题集合
	* @author 韩志彬   
	* @date 2018年8月6日 上午7:54:35 
	* @version V1.0 
	* @param page 当前页
	* @param limit 页面容量
	* @return 试题集合
	 */
	@RequestMapping("/list.do")
	@ResponseBody
	public Map<String, Object> listQuestions(int page,int limit){
		Map<String,Object> queryMap = new HashMap<String,Object>();
		queryMap.put("page", (page-1)*limit);
		queryMap.put("limit", limit);
		queryMap.put("status", MyConstants.DATA_STATUS_NO);
		List<Question> list = questionService.listQuestions(queryMap);
		if(list != null && list.size() > 0) {
			for (Question question : list) {
				Books books = booksService.getBooksNameById(question.getBookId());
				question.setBooksName(books.getName());
				Chapter chapter = chapterService.getChapterNameById(question.getChapterId());
				question.setChapterName(chapter.getName());
				QuestionTypes questionTypes = questionTypesService.getquestionTypesNameById(question.getQuestiontypesId());
				question.setQuestionTypesName(questionTypes.getName());
			}
		}
		int count = questionService.getCountByQuestion();
		Map<String, Object> map = ReturnMap.createMap(0, "", count, list);
		return map;
	}
	
	/**
	 * 
	* @Title: deleQuestionById 
	* @Description:  单个逻辑删除试题
	* @author 韩志彬   
	* @date 2018年8月6日 上午7:55:31 
	* @version V1.0 
	* @param id 试题id
	* @return 消息体
	 */
	@RequestMapping("/del.do")
	@ResponseBody
	public Map<String,Object> deleQuestionById(Integer id){
		Map<String,Object> map = new HashMap<String,Object>();
		
		if(id == null) {
			map.put("status", "5000");
			map.put("msg", "数据异常,无法删除");
			return map;
		}
		
		try {
			questionService.deleQuestionById(MyConstants.DATA_STATUS_OK,id);
			map.put("status", "200");
			map.put("msg", "删除成功");
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			map.put("status", "5000");
			map.put("msg", "数据异常,无法删除");
			return map;
		}
	}
	
	/**跳转导入试题页面*/
	@RequestMapping("/showButtons.do")
	public String toShowButtonsView() {
		return "question/question_buttons";
	}
	
	/**
	 * 
	* @Title: saveQuestion 
	* @Description:  保存或修改试题
	* @author 韩志彬   
	* @date 2018年8月6日 上午7:56:38 
	* @version V1.0 
	* @param question 试题参数
	* @return 消息体
	 */
	@RequestMapping("/save.do")
	@ResponseBody
	public Map<String,Object> saveQuestion(Question question){
		
		return null;
	}
	
	/**
	 * 
	* @Title: searchQuestion 
	* @Description:  动态查询
	* @author 韩志彬   
	* @date 2018年8月6日 上午7:56:58 
	* @version V1.0 
	* @param question 试题参数
	* @return 符合要求的试题集合
	 */
	@RequestMapping("/dynSearch.do")
	@ResponseBody
	public Map<String,Object> searchQuestion(Question question){
		return null;
	}
	/**
	 * 
	* @Title: importSingleQuestion 
	* @Description:  单选题POI导入
	* @author 韩志彬   
	* @date 2018年8月7日 上午12:33:30 
	* @version V1.0 
	* @param file 上传文件
	* @param session 获取用户信息
	* @return 消息体
	 */
	@SuppressWarnings("unused")
	@RequestMapping("/impSingle.do")
	@ResponseBody
	public Map<String,Object> importSingleQuestion(@RequestParam("file")MultipartFile file,HttpSession session){
		Map<String,Object> map = new HashMap<String,Object>();
		List<Object> msgList = new ArrayList<>();
		
		List<Question> list = new ArrayList<Question>();
		Integer ids=null;
		Integer booksId=null;
		try {
			HSSFWorkbook book = new HSSFWorkbook(file.getInputStream());
			HSSFSheet sheet = book.getSheetAt(0);
			if(sheet.getLastRowNum() == 0 || sheet.getLastRowNum() == 1) {map.put("msg", "文件中没有要导入的真实数据...");return map;}
			if(sheet.getNumMergedRegions() != 0) {map.put("msg", "本文件不允许使用合并单元格...");return map;}
			for (Row row : sheet) {
				if(row.getRowNum() == 0) {continue;} 
				if(row.getRowNum() == 1) {continue;}
				if(!(MyConstants.QUESTION__TITLE_NAME.equals(sheet.getRow(0).getCell(0).getStringCellValue().trim()) ||
					 MyConstants.QUESTION_TITLE_CONTENT.equals(sheet.getRow(0).getCell(1).getStringCellValue().trim()) ||
					 MyConstants.QUESTION_TITLE_ANSWER.equals(sheet.getRow(0).getCell(2).getStringCellValue().trim()) ||
					 MyConstants.QUESTION_TITLE_ANALYSIS.equals(sheet.getRow(0).getCell(3).getStringCellValue().trim()) ||
					 MyConstants.QUESTION_TITLE_TYPE.equals(sheet.getRow(0).getCell(4).getStringCellValue().trim()) ||
					 MyConstants.QUESTION_TITLE_STAGE.equals(sheet.getRow(0).getCell(5).getStringCellValue().trim()) ||
					 MyConstants.QUESTION_TITLE_BOOK.equals(sheet.getRow(0).getCell(6).getStringCellValue().trim()) ||
					 MyConstants.QUESTION_TITLE_CHAPTER.equals(sheet.getRow(0).getCell(7).getStringCellValue().trim()))){
					 map.put("msg", "请不要更改列的顺序或值...");return map;}
				
				Question question = new Question();
				if(row.getPhysicalNumberOfCells() != 8) {
					
					Integer errCount = row.getRowNum()+1;
					msgList.add(errCount +"行的数据中存在空值");
					continue;
				}else {
					for (Cell cell : row) {
						int index = cell.getColumnIndex();
							if(index == 0) {
								String value = cell.getStringCellValue();
								if(value == null || value.trim().length() <= 0) {
									
									Integer errCount = row.getRowNum()+1;
									
									msgList.add(errCount +"行的题目存在空值");
									break;
								}else {
									question.setName(value);
								}
							}
							
							if(index == 1) {
								String value = cell.getStringCellValue();
								if(value == null || value.trim().length() <= 0) {
									
									Integer errCount = row.getRowNum()+1;
									
									msgList.add(errCount +"行的内容存在空值");
									break;
								}else {
									boolean temp = value.contains(" ".toString());
									if(!temp) {
										
										Integer errCount = row.getRowNum()+1;
										
										msgList.add(errCount +"行的内容空格异常");
										break;
									}else {
										String[] split = value.split(" ");
										if(split.length != 4) {
											
											Integer errCount = row.getRowNum()+1;
											
											msgList.add(errCount +"行的内容空格异常或选项个数不等于4");
											break;
										}else {
											if(!split[0].toUpperCase().startsWith("A")) {
												
												Integer errCount = row.getRowNum()+1;
												
												msgList.add(errCount +"行的内容不包含A选项");
												break;
											}else if(!split[1].toUpperCase().startsWith("B")) {
												
												Integer errCount = row.getRowNum()+1;
												
												msgList.add(errCount +"行的内容不包含B选项");
												break;
											}else if(!split[2].toUpperCase().startsWith("C")) {
												
												Integer errCount = row.getRowNum()+1;
												
												msgList.add(errCount +"行的内容不包含C选项");
												break;
											}else if(!split[3].toUpperCase().startsWith("D")) {
												
												Integer errCount = row.getRowNum()+1;
												
												msgList.add(errCount +"行的内容不包含D选项");
												break;
											}else {
												question.setContent(value);
											}
										}
									}
								}
							}
							if(index == 2) {
								String value = cell.getStringCellValue();
								if(value == null || value.trim().length() <= 0) {
									Integer errCount = row.getRowNum()+1;
									msgList.add(errCount +"行不存在数据");
									continue;
								}else {
									if(value.length() != 1) {
										Integer errCount = row.getRowNum()+1;
										msgList.add(errCount +"行不是一个答案");
										continue;
									}else {
										if(value.contains("A") || value.contains("B") || value.contains("C") || value.contains("D")) {
											question.setAnswer(value);
										}else {
											Integer errCount = row.getRowNum()+1;
											msgList.add(errCount +"行的答案值不在A-D范围内");
											continue;
										}
									}
								}
							}
							if(index == 3) {
								String value = cell.getStringCellValue();
								if(value == null || value == "") {
									Integer errCount = row.getRowNum()+1;
									msgList.add(errCount +"行的解析不存在数据");
									continue;
								}else {
									question.setAnalysis(value);
								}
							}
							if(index == 4) {
								String value = cell.getStringCellValue();
								if(value == null || value == "") {
									Integer errCount = row.getRowNum()+1;
									msgList.add(errCount +"行的类型不存在数据");
									continue;
								}else {
									if("单选题".equals(value)) {
										question.setQuestiontypesId(1);
									}else {
										Integer errCount = row.getRowNum()+1;
										msgList.add(errCount +"行的题目类型存在异常");
										continue;
									}
								}
							}
					
							if(index == 5) {
								String value = cell.getStringCellValue().trim();
								if(value == null || value == "") {
									Integer errCount = row.getRowNum()+1;
									msgList.add(errCount +"行的书名称不存在数据");
									continue;
								}else {
									Integer id = stageService.getStageIdByStageName(value);
									if(id != null) {
										ids = id;
										question.setStageId(id);
									}else {
										Integer errCount = row.getRowNum()+1;
										msgList.add(errCount +"行的阶段名称不正确");
										continue;
									}	
								}
							}
							if(index == 6) {
								String value = cell.getStringCellValue().trim();
								if(value == null || value == "") {
									Integer errCount = row.getRowNum()+1;
									msgList.add(errCount +"行的书名不存在");
									continue;

								}else {
									if(ids != null) {
										Integer bookId = booksService.getBooksIdByBooksName(ids,value);
										booksId = bookId;
										question.setBookId(bookId);
									}else {
										Integer errCount = row.getRowNum()+1;
										msgList.add(errCount +"行书名与阶段不匹配");
										continue;
									}
								}
								if(ids != null) {
									Integer bookId = booksService.getBooksIdByBooksName(ids,value);
									booksId = bookId;
									question.setBookId(bookId);
								}else {
									Integer errCount = row.getRowNum()+1;
									msgList.add(errCount +"行的书名不存在或书名与阶段不匹配");
									continue;
								}
							}
							if(index == 7) {
								String value = cell.getStringCellValue().trim();
								Integer id = chapterService.getChapterIdByChapterName(ids,booksId,value);
								if(id != null) {
									question.setChapterId(id);
								}
							}
							
						}
					}
				
				if(question.getName() != null && question.getContent() != null && question.getAnswer() != null &&
						question.getAnalysis() != null && question.getQuestiontypesId() != null &&question.getBookId() != null
						&& question.getChapterId() != null && question.getStageId() != null ) {
					
					User user = (User) session.getAttribute("user");
					question.setCreateBy(user.getUsername());
					question.setCreateTime(new Date());
					question.setModifyBy(user.getUsername());
					question.setModifyTime(new Date());
					question.setStatus("30");
					question.setProhibition("0");
					question.setWeight("3");
					
					
					list.add(question);
				}
					System.out.println(question.getName()+"====="+question.getContent()+
							"====="+question.getAnswer()+"====="+question.getAnalysis()+"====="+question.getQuestiontypesId()+"====="+question.getStageId()+"====="+question.getBookId()+"----"+question.getChapterId());
					System.err.println("集合长度:" +list.size());
			}
			
			questionService.saveQuestionByList(list);
			
			
			for (Object object : msgList) {
				System.err.println(">>>>>>>>>>>>>>>>>>>>>消息>>>>>>>>>>>>>>>>"+object);
			}
			map.put("msg", "保存成功");
		} catch (IOException e) {
			e.printStackTrace();
			map.put("msg", "保存失败,错误消息是:" +e.getMessage());
		}
		return map;
	}
}
