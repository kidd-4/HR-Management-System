package com.icss.java.data.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.java.data.dao.divisionDao;
import com.icss.java.data.dao.divisionEntity;

public class DeleteDivisionAction extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置请求编码，防止中文乱码
		request.setCharacterEncoding("UTF-8");
		
		// 通过请求对象request获得页面参数值
		String staffID = request.getParameter("staffID");
		System.out.println("staffID:"+staffID);
		
		// 学生数据库操作DAO
		divisionDao sd = new divisionDao();
		
		if(sd.deleteUser(staffID)){
			// 跳转      通过请求跳转到页面或Servlet
			request.getRequestDispatcher("doQueryDivision").forward(request, response);
		}else{
			
			// 绑定错误信息到请求中
			request.setAttribute("errorMes", "删除信息失败！");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
		
	}

}
