package com.yimai.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yimai.ov.PageOrder;
import com.yimai.pojo.Order;
import com.yimai.service.OrderLogic;
import com.yimai.service.Impl.OrderLogicImpl;

/**
 * Servlet implementation class Order
 */
@WebServlet("/manage/Order")
public class manageOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public manageOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		OrderLogic service=new OrderLogicImpl();
		PageOrder<Order> list=service.getPagesOrderDetail(request);
		request.setAttribute("orderinfo", list);
		request.getRequestDispatcher("order.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
