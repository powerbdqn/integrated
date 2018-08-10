package com.integrate.pojo.system;

import java.beans.Transient;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Menu {
    private Integer id;

    private String title;

    private String href;

    private String description;

    private Integer priority;

    private String status;

    private String prohibition;

    private String createUser;

    private Date createTime;

    private String modifyUser;

    private Date mdifyTime;

    private Integer pid;

    
    private Set<Role> roles = new HashSet<Role>(0);
    
    private Set<Menu> children = new HashSet<Menu>();
    
    private Menu parentMenu;
    
    @Transient
    public Integer getpId(){
        if(parentMenu == null){
            return 0; //父级id
        }else{
            return parentMenu.getId();
        }
    }
    
    public Set<Role> getRoles() {
		return roles;
	}



	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}



	public Set<Menu> getChildren() {
		return children;
	}



	public void setChildren(Set<Menu> children) {
		this.children = children;
	}



	public Menu getParentMenu() {
		return parentMenu;
	}



	public void setParentMenu(Menu parentMenu) {
		this.parentMenu = parentMenu;
	}



	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
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

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getModifyUser() {
        return modifyUser;
    }

    public void setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser == null ? null : modifyUser.trim();
    }

    public Date getMdifyTime() {
        return mdifyTime;
    }

    public void setMdifyTime(Date mdifyTime) {
        this.mdifyTime = mdifyTime;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

	@Override
	public String toString() {
		return "Menu [id=" + id + ", title=" + title + ", href=" + href + ", description=" + description + ", priority="
				+ priority + ", status=" + status + ", prohibition=" + prohibition + ", createUser=" + createUser
				+ ", createTime=" + createTime + ", modifyUser=" + modifyUser + ", mdifyTime=" + mdifyTime + ", pid="
				+ pid + ", roles=" + roles + ", parentMenu=" + parentMenu + "]";
	}
    
    
}