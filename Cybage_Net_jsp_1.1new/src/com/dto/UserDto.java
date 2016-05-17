package com.dto;

import java.sql.SQLException;

import com.dao.LoginDao;

public class UserDto {

	
	private Integer id;
	private String name;
	private String pass;
	private String type;
	
	private LoginDao loginDao;
	
	public UserDto() {
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
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public LoginDao getLoginDao() {
		return loginDao;
	}

	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
		}

	@Override
	public String toString() {
		return "UserDao [id=" + id + ", name=" + name + ", pass=" + pass + ", type=" + type + "]";
	}
	
	public String getRole() throws SQLException
	{
		System.out.println("in role");
		return loginDao.getCheckUserCredintials(name, pass);
	}
	
}