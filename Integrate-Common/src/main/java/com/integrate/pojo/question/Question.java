package com.integrate.pojo.question;

import java.util.Date;

import javax.persistence.Transient;

/**
 * 题目类
 * 
 * @author Administrator
 *
 */
public class Question {

	private Integer id; // 题目id
	private String name;// 题干
	private String content;// 内容
	private String prohibition; // 1是启用 0是禁止
	private String status; // 是否删除 10是 30否
	private String answer;// 保存数据库时,禁止用任何符号分割,保证数据的原子性
	private String analysis;// 试题解析
	private Integer bookId; // 书id
	private Integer questiontypesId;// 类型id
	private Integer stageId;// 阶段id
	private Integer chapterId; // 章节id
	private Date createTime;// 创建时间
	private String createBy;// 创建人
	private Date modifyTime;// 修改时间
	private String modifyBy;// 修改人
	private String weight; //权重
	
	@Transient
	private Date startTime; //不存入数据库的字段 仅限查询使用
	@Transient
	private Date endTime; //不存入数据库的字段 仅限查询使用

	@Transient
	private String booksName;//不存入数据库的字段 仅限字段显示
	@Transient
	private String chapterName;//不存入数据库的字段 仅限字段显示
	@Transient
	private String questionTypesName;//不存入数据库的字段 仅限字段显示
	
	
	public String getQuestionTypesName() {
		return questionTypesName;
	}

	public void setQuestionTypesName(String questionTypesName) {
		this.questionTypesName = questionTypesName;
	}

	public String getBooksName() {
		return booksName;
	}

	public void setBooksName(String booksName) {
		this.booksName = booksName;
	}

	public String getChapterName() {
		return chapterName;
	}

	public void setChapterName(String chapterName) {
		this.chapterName = chapterName;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public Integer getChapterId() {
		return chapterId;
	}

	public void setChapterId(Integer chapterId) {
		this.chapterId = chapterId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getProhibition() {
		return prohibition;
	}

	public void setProhibition(String prohibition) {
		this.prohibition = prohibition;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getAnalysis() {
		return analysis;
	}

	public void setAnalysis(String analysis) {
		this.analysis = analysis;
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public Integer getQuestiontypesId() {
		return questiontypesId;
	}

	public void setQuestiontypesId(Integer questiontypesId) {
		this.questiontypesId = questiontypesId;
	}

	public Integer getStageId() {
		return stageId;
	}

	public void setStageId(Integer stageId) {
		this.stageId = stageId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public String getModifyBy() {
		return modifyBy;
	}

	public void setModifyBy(String modifyBy) {
		this.modifyBy = modifyBy;
	}
}
