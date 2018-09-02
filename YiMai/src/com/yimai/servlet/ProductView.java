package com.yimai.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yimai.pojo.Product;
import com.yimai.service.ProductLogic;
import com.yimai.service.Impl.ProductLogicImpl;

/**
 * Servlet implementation class ProductView
 */
@WebServlet("/ProductView")
public class ProductView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		ProductLogic service=new ProductLogicImpl();
		String ep_id=request.getParameter("ep_id");
		Cookie cookie=new Cookie("ep_ids", ep_id+";");
		cookie.setPath("/");
		cookie.setMaxAge(60);
		response.addCookie(cookie);
		if(ep_id ==null || ep_id.isEmpty()) {
			response.sendRedirect("Index");
			return ;
		}else {
			Product product=service.getEP(request);
			request.setAttribute("product", product);
			request.getRequestDispatcher("product-view.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
