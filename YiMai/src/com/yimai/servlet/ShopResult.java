package com.yimai.servlet;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yimai.service.ShoppingLogic;
import com.yimai.service.Impl.ShoppingLogicImpl;
import com.yimai.util.OrderID;

/**
 * Servlet implementation class ShopResult
 */
@WebServlet("/ShopResult")
public class ShopResult extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShopResult() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		ShoppingLogic service=new ShoppingLogicImpl();
		try {
			service.addOrders(request);
			service.delProduct(request);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("shopping-result.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
