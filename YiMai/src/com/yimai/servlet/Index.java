package com.yimai.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.Cookies;

import com.yimai.pojo.Product;
import com.yimai.service.ProductLogic;
import com.yimai.service.UserLogic;
import com.yimai.service.Impl.ProductLogicImpl;
import com.yimai.service.Impl.UserLogicImpl;

/**
 * Servlet implementation class Index
 */
@WebServlet("/Index")
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Index() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String opr=request.getParameter("opr");
		if(opr!=null && opr.equals("cancel")) {
			request.getSession().removeAttribute("user");
		}
		Cookie[] cookies=request.getCookies();
		for (int i = 0; i < cookies.length; i++) {
			if(cookies[i].equals("ep_ids")) {
				System.out.println(cookies[i].getValue());
				return ;
			}
		}
		ProductLogic ser=new ProductLogicImpl();
		List<Product> list=ser.getSpecialProducts();
		request.setAttribute("sp",list);
		list=ser.getAllProducts();
		request.setAttribute("pro", list);
		request.setAttribute("index", true);
		request.getRequestDispatcher("index.jsp").forward(request, response);
		return ;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
