package com.icss.java.data.action;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.java.data.dao.AbsentDao;
import com.icss.java.data.dao.AbsentEntity;

public class AbsentUpdateAction extends HttpServlet {

	
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
		String absenttime =request.getParameter("absenttime");
		
		String reason = request.getParameter("reason");
		
		
		
		// 学生实体对象
		AbsentEntity de = new AbsentEntity();
		de.setStaffID(staffID);
		de.setName(Name);
		de.setAbsenttime(toDate(absenttime));// 把字符串转换为数字类型
	     de.setReason(reason);
				
		// 学生数据库操作DAO
		AbsentDao dd = new AbsentDao();
		 if(dd.updateUser(de)){
			// 跳转      通过请求跳转到页面或Servlet
			request.getRequestDispatcher("doQueryAbsent").forward(request, response);
		}else{
			
			// 绑定错误信息到请求中
			request.setAttribute("errorMes", "修改缺勤记录失败！");
			request.getRequestDispatcher("error.jsp").forward(request, response);
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

