package com.icss.java.data.action;

import java.io.IOException;


import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.java.data.dao.UserDao;

public class LoginAction extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 设置请求编码，防止中文乱码
		request.setCharacterEncoding("UTF-8");
		
		// 通过请求对象request获得页面参数值
		String userID = request.getParameter("userID");
		String userPassword = request.getParameter("userPassword");
		
		System.out.println("userID:"+userID);
		System.out.println("userPassword:"+userPassword);
		
		// 学生数据库操作DAO
		UserDao sd = new UserDao();
		
		// 调用登录方法
		if(sd.loginUser(userID, userPassword)){
			System.out.println(userID+"登录成功！");
			
			// 跳转      通过请求跳转到页面或Servlet
			request.getRequestDispatcher("index.htm").forward(request, response);
			
		}else{
			System.out.println("用户名或密码错误，登录失败！");
			request.setAttribute("errorMes", "用户名或密码错误，登录失败！");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}

		
	
	}

}
