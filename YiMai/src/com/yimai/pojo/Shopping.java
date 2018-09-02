package com.yimai.pojo;

public class Shopping {
	private String eu_user_id;
	private int ep_id;
	private int number;
	public Shopping() {}
	public String getEu_user_id() {
		return eu_user_id;
	}
	public void setEu_user_id(String eu_user_id) {
		this.eu_user_id = eu_user_id;
	}
	public int getEp_id() {
		return ep_id;
	}
	public void setEp_id(int ep_id) {
		this.ep_id = ep_id;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public Shopping(String eu_user_id, int ep_id, int number) {
		super();
		this.eu_user_id = eu_user_id;
		this.ep_id = ep_id;
		this.number = number;
	}
	
}
