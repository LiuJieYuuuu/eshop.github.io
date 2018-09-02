package com.yimai.pojo;

import java.sql.Timestamp;

public class Order {
	private String eo_id;
	private String userid;
	private String username;
	private String address;
	private Timestamp time;
	private double cost;
	private int status;
	
	public Order() {}
	
	public Order(String eo_id, String userid, String username, String address, Timestamp time, double cost,
			int status) {
		super();
		this.eo_id = eo_id;
		this.userid = userid;
		this.username = username;
		this.address = address;
		this.time = time;
		this.cost = cost;
		this.status = status;
	}
	public String getEo_id() {
		return eo_id;
	}
	public void setEo_id(String eo_id) {
		this.eo_id = eo_id;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Order [eo_id=" + eo_id + ", userid=" + userid + ", username=" + username + ", address=" + address
				+ ", time=" + time + ", cost=" + cost + ", status=" + status + "]";
	}
	
	
}
