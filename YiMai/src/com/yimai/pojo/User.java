package com.yimai.pojo;

import java.sql.Timestamp;

public class User {
	private String id;
	private String username;
	private String password;
	private String sex;
	private Timestamp date;
	private String identity;
	private String mail;
	private String tel;
	private int login;
	private int status;
	private String address;
	
	public User() {}
	
	
	
	public User(String id, String username, String password, String sex, Timestamp date, String identity, String mail,
			String tel, int login, int status,String address) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.sex = sex;
		this.date = date;
		this.identity = identity;
		this.mail = mail;
		this.tel = tel;
		this.login = login;
		this.status = status;
		this.address=address;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	public String getIdentity() {
		return identity;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public int getLogin() {
		return login;
	}
	public void setLogin(int login) {
		this.login = login;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
