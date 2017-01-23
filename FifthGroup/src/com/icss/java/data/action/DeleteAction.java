package com.icss.java.data.action;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.java.data.dao.UserDao;


public class DeleteAction extends HttpServlet {

	
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
		System.out.println("userID:"+userID);
		
		// 学生数据库操作DAO
		UserDao sd = new UserDao();
		
		if(sd.deleteUser(userID)){
			// 跳转      通过请求跳转到页面或Servlet
			request.getRequestDispatcher("doQueryAll").forward(request, response);
		}else{
			
			// 绑定错误信息到请求中
			request.setAttribute("errorMes", "删除用户失败！");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
	}

}
