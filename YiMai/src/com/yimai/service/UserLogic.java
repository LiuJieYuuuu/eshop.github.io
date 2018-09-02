package com.yimai.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface UserLogic {
	void registerImpl(HttpServletRequest request,HttpServletResponse response) throws Exception;
	void loginImpl(HttpServletRequest request,HttpServletResponse response) throws Exception;
}
