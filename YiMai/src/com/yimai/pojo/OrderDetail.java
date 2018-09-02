package com.yimai.pojo;

public class OrderDetail {
	private String eod_id;
	private String eo_id;
	private int ep_id;
	private int ep_number;
	private double price;
	
	public OrderDetail() {}
	
	public OrderDetail(String eod_id, String eo_id, int ep_id, int ep_number, double price) {
		super();
		this.eod_id = eod_id;
		this.eo_id = eo_id;
		this.ep_id = ep_id;
		this.ep_number = ep_number;
		this.price = price;
	}
	public String getEod_id() {
		return eod_id;
	}
	public void setEod_id(String eod_id) {
		this.eod_id = eod_id;
	}
	public String getEo_id() {
		return eo_id;
	}
	public void setEo_id(String eo_id) {
		this.eo_id = eo_id;
	}
	public int getEp_id() {
		return ep_id;
	}
	public void setEp_id(int ep_id) {
		this.ep_id = ep_id;
	}
	public int getEp_number() {
		return ep_number;
	}
	public void setEp_number(int ep_number) {
		this.ep_number = ep_number;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "OrderDetail [eod_id=" + eod_id + ", eo_id=" + eo_id + ", ep_id=" + ep_id + ", ep_number=" + ep_number
				+ ", price=" + price + "]";
	}
	
}
