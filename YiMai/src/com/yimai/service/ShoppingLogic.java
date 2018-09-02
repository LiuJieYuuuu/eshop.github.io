package com.yimai.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.yimai.ov.ShopCar;

public interface ShoppingLogic {
	boolean addProduct(HttpServletRequest request);
	boolean updatePnum(HttpServletRequest request);
	boolean delProduct(HttpServletRequest request);
	List<ShopCar> getShoppes(HttpServletRequest request);
	boolean addOrders(HttpServletRequest request);
}
