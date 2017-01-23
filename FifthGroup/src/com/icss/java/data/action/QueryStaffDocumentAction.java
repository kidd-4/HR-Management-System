package com.icss.java.data.action;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.icss.java.data.dao.StaffDocumentDao;
import com.icss.java.data.dao.StaffDocumentEntity;


public class QueryStaffDocumentAction extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 显示所有的用户信息
		System.out.println("显示所有档案信息...");
		
		// 用户数据库操作DAO
		StaffDocumentDao sd = new StaffDocumentDao();
		
		//　获得所有的用户信息
		List<StaffDocumentEntity> list = sd.queryAll();
		
		// 绑定数据到请求对象中
		request.setAttribute("stuList", list);
		
		// 跳转到用户主页
		request.getRequestDispatcher("StaffDocument.jsp").forward(request, response);
		
	}

}
