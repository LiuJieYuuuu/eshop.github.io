package com.yimai.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yimai.service.UserLogic;
import com.yimai.service.Impl.UserLogicImpl;

/**
 * Servlet implementation class Regist
 */
@WebServlet("/Regist")
public class Regist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Regist() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String key=request.getParameter("veryCode");
		String register=request.getParameter("type");
		if(register==null) {
			request.setAttribute("r",true);
			request.getRequestDispatcher("register.jsp").forward(request, response);
			return ;
		}else {
			if(!key.equals(request.getSession().getAttribute("rCode"))) {
				request.getSession().setAttribute("code",true);
				response.sendRedirect("Regist");
				return;
			}
			UserLogic service=new UserLogicImpl();
			try {
				service.registerImpl(request, response);
			} catch (Exception e) {
				e.printStackTrace();
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
