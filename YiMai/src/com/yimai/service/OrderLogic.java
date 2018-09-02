package com.yimai.service;

import javax.servlet.http.HttpServletRequest;

import com.yimai.ov.PageOrder;
import com.yimai.pojo.Order;

public interface OrderLogic {
	PageOrder<Order> getPagesOrderDetail(HttpServletRequest request);
}
