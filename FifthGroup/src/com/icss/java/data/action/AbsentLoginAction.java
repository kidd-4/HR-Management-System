package com.icss.java.data.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.java.data.dao.AbsentDao;


public class AbsentLoginAction extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 设置请求编码，防止中文乱码
		request.setCharacterEncoding("UTF-8");
		
		// 通过请求对象request获得页面参数值
		String userId = request.getParameter("userID");
		String userPassword = request.getParameter("userPassword");
		
		System.out.println("userID:"+userId);
		System.out.println("userPassword:"+userPassword);
		
		// 学生数据库操作DAO
		AbsentDao dd = new AbsentDao();
		
		// 调用登录方法
		//if(la.loginUser(userId, userPassword)){
			System.out.println(userId+"登录成功！");
			
			// 跳转      通过请求跳转到页面或Servlet
			request.getRequestDispatcher("doQueryAbsent").forward(request, response);
			
		//}else{
			//System.out.println("用户名或密码错误，登录失败！");
			//request.setAttribute("errorMes", "用户名或密码错误，登录失败！");
			//request.getRequestDispatcher("error.jsp").forward(request, response);
		}

		
	}

	


