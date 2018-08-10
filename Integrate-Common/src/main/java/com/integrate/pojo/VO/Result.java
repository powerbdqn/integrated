package com.integrate.pojo.VO;

import java.util.HashSet;
import java.util.Set;

import com.integrate.pojo.system.Menu;

/**
 * 动态菜单反参类
 * @author Administrator
 *
 */
public class Result {

	private String title; //标题
	private String icon;  //图标
	private boolean spread;//是否默认选中
	private Set<Menu> children = new HashSet<Menu>(0);//根节点下的子节点
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public boolean getSpread() {
		return spread;
	}
	public void setSpread(boolean spread) {
		this.spread = spread;
	}
	public Set<Menu> getChildren() {
		return children;
	}
	public void setChildren(Set<Menu> children) {
		this.children = children;
	}

	
}