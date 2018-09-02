package com.yimai.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.yimai.pojo.Product;

public interface ProductLogic {
	List<Product> getAllProducts();
	List<Product> getSpecialProducts();
	Product getEP(HttpServletRequest request);
}
