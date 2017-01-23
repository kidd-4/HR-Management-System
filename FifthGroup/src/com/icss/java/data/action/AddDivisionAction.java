package com.icss.java.data.action;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.java.data.dao.divisionDao;
import com.icss.java.data.dao.divisionEntity;
import com.icss.java.data.dao.divisionEntity;

public class AddDivisionAction extends HttpServlet {

	
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
	    String Name = request.getParameter("Name");
		String time = request.getParameter("time");
		String resaon = request.getParameter("resaon");
		String category = request.getParameter("category");
		

		System.out.println(staffID + Name + time + resaon + category);
		// 学生实体对象
		divisionEntity di = new divisionEntity();
		di.setStaffID(staffID);
		di.setName(Name);
		di.setTime(toDate(time));
		di.setResaon(resaon);
		di.setCategory(category);
		
		
		// 学生数据库操作DAO
		divisionDao sd = new divisionDao();
		
		if(sd.addUser(di)){
			// 跳转      通过请求跳转到页面或Servlet
			
			request.getRequestDispatcher("doQueryDivision").forward(request, response);
			
		}else{
			
			// 绑定错误信息到请求中
			request.setAttribute("errorMes", "增加人员调配失败！");
			request.getRequestDispatcher("errorstaffman.jsp").forward(request, response);
		}
		
	}
	  public  Date toDate(String date) {   
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
			java.util.Date Date=new java.util.Date();
			try {
				Date = df.parse(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}   
			Date result=new Date(Date.getTime()); 
			return  result;
		}
}
