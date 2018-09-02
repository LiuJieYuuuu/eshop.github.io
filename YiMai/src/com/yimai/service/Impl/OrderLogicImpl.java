package com.yimai.service.Impl;

import javax.servlet.http.HttpServletRequest;

import com.yimai.dao.OrderDAO;
import com.yimai.ov.PageOrder;
import com.yimai.pojo.Order;
import com.yimai.service.OrderLogic;

public class OrderLogicImpl implements OrderLogic {

	@Override
	public PageOrder<Order> getPagesOrderDetail(HttpServletRequest request) {
		PageOrder<Order> porder=new PageOrder<Order>();
		String userId=null;
		String userName=null;
		userId=request.getParameter("orderId");
		if(userId!=null && userId.isEmpty())
			userId=null;
		userName=request.getParameter("userName");
		if(userName!=null && userName.isEmpty())
			userName=null;
		OrderDAO dao=new OrderDAO();
		int cpage=1;
		String page=request.getParameter("cpage");
		if(page!=null) {
			porder.setCurPage(Integer.parseInt(page));
		}else {
			porder.setCurPage(cpage);
		}
		porder.setPageSize(4);
		porder.setTotalRecords(dao.getRecords());
		porder.setPageTotal((int) Math.ceil(1.0*porder.getTotalRecords()/porder.getPageSize()));
		porder.setList(dao.getOrders(porder.getCurPage(), porder.getPageSize(),userId,userName));
		return porder;
	}

}
