package com.icss.java.data.action;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.java.data.dao.AbsentDao;
import com.icss.java.data.dao.AbsentEntity;


public class AbsentQueryAction extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 显示所有的用户信息
		System.out.println("显示所有户信息...");
		
		// 用户数据库操作DAO
		AbsentDao dd = new AbsentDao();
		
		//　获得所有的用户信息
		List<AbsentEntity> list = dd.queryAll();
		// 绑定数据到请求对象中

		request.setAttribute("stuList", list);
		
		// 跳转到用户主页
		request.getRequestDispatcher("AbsentRecord.jsp").forward(request, response);
		
	}

}