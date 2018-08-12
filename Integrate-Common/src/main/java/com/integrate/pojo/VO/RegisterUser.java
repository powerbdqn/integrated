package com.integrate.pojo.VO;

import java.util.Date;

public class RegisterUser {

	private String username;
	private String password;
	private String cord;
	private Date birthday;
	private String msg;
	private String sex;
	private String address;
	
	public RegisterUser() {}
	
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCord() {
		return cord;
	}
	public void setCord(String cord) {
		this.cord = cord;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
}
