package com.icss.java.data.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.java.data.dao.StaffDocumentDao;
import com.icss.java.data.dao.StaffDocumentEntity;
import com.icss.java.data.dao.UserDao;
import com.icss.java.data.dao.UserEntity;

public class UpdateStaffDocumentAction extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 设置请求编码，防止中文乱码
		request.setCharacterEncoding("UTF-8");
		
		// 通过请求对象request获得页面参数值
		String docID = request.getParameter("docID");
		String staffID= request.getParameter("staffID");
		String docCon = request.getParameter("docCon");
		String docTime = request.getParameter("docTime");
		
		
		// 学生实体对象
		StaffDocumentEntity se = new StaffDocumentEntity();
		se.setDocID(docID);
		se.setStaffID(staffID);
		se.setDocCon(docCon);
	
		
		// yyyy-MM-dd
		se.setDocTime(toDate(docTime));
		
		
		// 学生数据库操作DAO
		StaffDocumentDao sd = new StaffDocumentDao();
		
		if(sd.updateStaffDocument(se)){
			// 跳转      通过请求跳转到页面或Servlet
			request.getRequestDispatcher("doQueryAll2").forward(request, response);
		}else{
			// 绑定错误信息到请求中
			request.setAttribute("errorMes", "修改员工档案失败！");
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
