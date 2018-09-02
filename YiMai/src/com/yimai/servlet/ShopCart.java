package com.yimai.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yimai.ov.ShopCar;
import com.yimai.service.ShoppingLogic;
import com.yimai.service.Impl.ShoppingLogicImpl;

/**
 * Servlet implementation class Shopping
 */
@WebServlet("/Shopping")
public class ShopCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShopCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String type=request.getParameter("type");
		String uri=request.getParameter("uri");
		String epid=request.getParameter("ep_id");
		ShoppingLogic service=new ShoppingLogicImpl();
		HttpSession session=request.getSession();
		if(type!=null && type.equals("pv")) {
			if(session.getAttribute("user")==null) {
				response.sendRedirect("Login?uri="+uri+"?ep_id="+epid);
				return;
			}else {
				if(service.addProduct(request)) {
					response.sendRedirect(uri+"?ep_id="+epid);
					return;
				}else {
					System.out.println("添加失败");
				}
			}
		}else {
			String u=request.getRequestURL().toString();
			if(session.getAttribute("user")==null) {
				response.sendRedirect("Login?uri="+u);
				return;
			}else {
				if(type!=null && type.equals("update")) {
					String number=request.getParameter("number");
					service.updatePnum(request);
				}
				if(type!=null && type.equals("del")) {
					service.delProduct(request);
				}
				List<ShopCar> list=service.getShoppes(request);
				request.setAttribute("list", list);
				request.getRequestDispatcher("shopping.jsp").forward(request, response);
				return ;
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
