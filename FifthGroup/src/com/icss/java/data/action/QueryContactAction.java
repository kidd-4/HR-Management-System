package com.icss.java.data.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.java.data.dao.ContactDao;
import com.icss.java.data.dao.ContactEntity;

public class QueryContactAction extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request,response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// 显示所有的用户信息
		System.out.println("显示所有合同信息");
		
		// 用户数据库操作DAO
		ContactDao sd = new ContactDao();
		
		//　获得所有的用户信息
		List<ContactEntity> list = sd.queryContact();
		
		// 绑定数据到请求对象中
		request.setAttribute("stuList", list);
		
		// 跳转到用户主页
		request.getRequestDispatcher("queryContact.jsp").forward(request, response);
	}

}

