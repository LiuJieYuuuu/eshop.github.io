package com.yimai.service.Impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.yimai.dao.ProductDAO;
import com.yimai.pojo.Product;
import com.yimai.service.ProductLogic;

public class ProductLogicImpl implements ProductLogic{

	@Override
	public List<Product> getAllProducts() {
		ProductDAO dao=new ProductDAO();
		return dao.getProducts();
	}

	@Override
	public List<Product> getSpecialProducts() {
		ProductDAO dao=new ProductDAO();
		return dao.getSpecialProducts();
	}

	@Override
	public Product getEP(HttpServletRequest request) {
		ProductDAO dao=new ProductDAO();
		int ep_id=Integer.parseInt(request.getParameter("ep_id"));
		Product p=dao.getEpIdProduct(ep_id);
		return p;
	}

}
