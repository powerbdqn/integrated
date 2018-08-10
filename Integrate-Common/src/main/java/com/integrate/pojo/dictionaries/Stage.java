package com.integrate.pojo.dictionaries;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 阶段类
 * @author Administrator
 *
 */
public class Stage {
	private Integer id;		//阶段id
	private String name;//S1 S2 S3 Y2 就业
	private String prohibition; // 1是启用 0是禁止
	private String status; //是否删除  10是 30否
	private Date createTime;//创建时间
	private String createBy;//创建人
	private Date modifyTime;//修改时间
	private String modifyBy;//修改人

	private Set<Books> books = new HashSet<Books>();
	
    public Set<Books> getBooks() {
		return books;
	}

	public void setBooks(Set<Books> books) {
		this.books = books;
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
        this.name = name == null ? null : name.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getProhibition() {
        return prohibition;
    }

    public void setProhibition(String prohibition) {
        this.prohibition = prohibition == null ? null : prohibition.trim();
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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
        this.modifyBy = modifyBy == null ? null : modifyBy.trim();
    }
}