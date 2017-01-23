package com.icss.java.data.action;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.java.data.dao.DepartDao;
import com.icss.java.data.dao.DepartEntity;

public class QueryDepartAction extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request,response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		System.out.println("显示所有部门信息");
		
		
		DepartDao sd = new DepartDao();
		
		
		List<DepartEntity> list = sd.queryAll();
		
		
		request.setAttribute("stuList", list);
		
	
		request.getRequestDispatcher("queryDepart.jsp").forward(request, response);
	}

}
