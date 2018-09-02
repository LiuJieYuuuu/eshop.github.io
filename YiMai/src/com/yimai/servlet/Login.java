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
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		if(uri!=null) {
			request.getSession().setAttribute("uri", uri);
		}
		if(type==null) {
			request.setAttribute("ch",1);
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return ;
		}else {
			String key=request.getParameter("veryCode");
			if(!key.equals(request.getSession().getAttribute("rCode"))) {
				request.getSession().setAttribute("code",2);
				response.sendRedirect("Login");
				return;
			}
			UserLogic service=new UserLogicImpl();
			try {
				service.loginImpl(request, response);
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
