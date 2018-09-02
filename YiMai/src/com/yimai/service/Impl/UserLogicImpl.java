package com.yimai.service.Impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yimai.dao.UserDAO;
import com.yimai.pojo.User;
import com.yimai.service.UserLogic;

public class UserLogicImpl implements UserLogic{

	@Override
	public void registerImpl(HttpServletRequest request,HttpServletResponse response) throws Exception {
		UserDAO dao=new UserDAO();
		User user=new User();
		String username=request.getParameter("userName");
		String pwd=request.getParameter("passWord");
		user.setId(username);
		user.setPassword(pwd);
		if(dao.registerUser(user)){
			request.getSession().setAttribute("regist",1);
			response.sendRedirect("Regist");
		}
		else {
			request.getSession().setAttribute("regist",2);
			response.sendRedirect("Regist");
		}
	}

	@Override
	public void loginImpl(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id=request.getParameter("userName");
		String pwd=request.getParameter("passWord");
		UserDAO dao=new UserDAO();
		if(dao.loginUser(id, pwd)) {
			User user=dao.getUserInfo(id);
			request.getSession().setAttribute("user", user);
			if(user.getStatus()==1) {
				request.setAttribute("check", 1);
				request.getRequestDispatcher("reg-result.jsp").forward(request, response);
				return ;
			}else {
				request.setAttribute("check", 3);
				request.getRequestDispatcher("reg-result.jsp").forward(request, response);
				return;
			}
		}else {
			request.setAttribute("check", 2);
			request.getRequestDispatcher("reg-result.jsp").forward(request, response);
		}
		
	}

}
