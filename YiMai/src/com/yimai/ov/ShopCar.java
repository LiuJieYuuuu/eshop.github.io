package com.yimai.ov;

public class ShopCar {
	private int ep_id;
	private int number;
	private String ep_name;
	private String filename;
	private double price;
	
	public ShopCar() {}
	
	public ShopCar(int ep_id, int number, String ep_name, String filename, double price) {
		super();
		this.ep_id = ep_id;
		this.number = number;
		this.ep_name = ep_name;
		this.filename = filename;
		this.price = price;
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
	public String getEp_name() {
		return ep_name;
	}
	public void setEp_name(String ep_name) {
		this.ep_name = ep_name;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ShopCar [ep_id=" + ep_id + ", number=" + number + ", ep_name=" + ep_name + ", filename=" + filename
				+ ", price=" + price + "]";
	}
	
}
