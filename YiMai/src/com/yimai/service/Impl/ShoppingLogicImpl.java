package com.yimai.service.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.yimai.dao.OrderDAO;
import com.yimai.dao.OrderDetailDAO;
import com.yimai.dao.ShopCarDAO;
import com.yimai.dao.ShoppingDAO;
import com.yimai.dao.UserDAO;
import com.yimai.ov.ShopCar;
import com.yimai.pojo.Order;
import com.yimai.pojo.OrderDetail;
import com.yimai.pojo.User;
import com.yimai.service.ShoppingLogic;
import com.yimai.util.OrderID;

public class ShoppingLogicImpl implements ShoppingLogic {

	@Override
	public boolean addProduct(HttpServletRequest request) {
		String userid=((User)request.getSession().getAttribute("user")).getId();
		int ep_id=Integer.parseInt(request.getParameter("ep_id"));
		int number=1;
		ShoppingDAO dao=new ShoppingDAO();
		if(dao.addProduct(userid, ep_id, number))
			return true;
		else
			return false;
	}

	@Override
	public boolean updatePnum(HttpServletRequest request) {
		int num=Integer.parseInt(request.getParameter("number"));
		String userid=((User)request.getSession().getAttribute("user")).getId();
		int ep_id=Integer.parseInt(request.getParameter("ep_id"));
		ShoppingDAO dao=new ShoppingDAO();
		if(dao.updateNumber(userid, ep_id, num))
			return true;
		else
			return false;
	}

	@Override
	public boolean delProduct(HttpServletRequest request) {
		ShoppingDAO dao=new ShoppingDAO();
		String userid=((User)request.getSession().getAttribute("user")).getId();
		String sep_id=request.getParameter("ep_id");
		String sep_all=request.getParameter("ep_all");
		if(sep_id==null && sep_all!=null) {
			String [] ep_ids=sep_all.split(";");
			for (int i = 0; i < ep_ids.length; i++) {
				int id=Integer.parseInt(ep_ids[i]);
				dao.delProduct(userid, id);
			}
			return true;
		}else {
			int ep_id=Integer.parseInt(sep_id);
			if(dao.delProduct(userid, ep_id))
				return true;
			else
				return false;
		}
	}

	@Override
	public List<ShopCar> getShoppes(HttpServletRequest request) {
		String userid=((User)request.getSession().getAttribute("user")).getId();
		List<ShopCar> list=new ArrayList<ShopCar>();
		ShopCarDAO dao=new ShopCarDAO();
		list=dao.getShopCar(userid);
		return list;
	}

	@Override
	public boolean addOrders(HttpServletRequest request) {
		OrderDAO odao=new OrderDAO();
		UserDAO udao=new UserDAO();
		ShopCarDAO sdao=new ShopCarDAO();
		OrderDetailDAO oddao=new OrderDetailDAO();
		String userid=((User)request.getSession().getAttribute("user")).getId();
		String sep_all=request.getParameter("ep_all");
		String [] ep_ids=sep_all.split(";");
		User user=udao.getUserInfo(userid);
		ShopCar sc=null;
		Order order=null;
		OrderDetail od=null;
		List<Order> olist=new ArrayList<Order>();
		List<OrderDetail> odlist=new ArrayList<OrderDetail>();
		for (int i = 0; i < ep_ids.length; i++) {
			int ep_id=Integer.parseInt(ep_ids[i]);
			String eo_id=OrderID.getOrderIdByUUId();
			sc=sdao.getShops(userid, ep_id);
			order=new Order();
			order.setEo_id(eo_id);
			order.setUserid(userid);
			order.setUsername(user.getUsername());
			order.setAddress(user.getAddress());
			order.setCost(sc.getPrice());
			olist.add(order);
			od=new OrderDetail();
			String eod_id=OrderID.getOrderDetailIdByUUId();
			od.setEod_id(eod_id);
			od.setEo_id(eo_id);
			od.setEp_id(ep_id);
			od.setEp_number(sc.getNumber());
			od.setPrice(sc.getPrice());
			odlist.add(od);
		}
		odao.addOrder(olist);
		oddao.addOrderDetail(odlist);
		return true;
	}

}
