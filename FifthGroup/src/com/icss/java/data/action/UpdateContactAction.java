package com.icss.java.data.action;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.java.data.dao.ContactDao;
import com.icss.java.data.dao.ContactEntity;

public class UpdateContactAction extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		
		String ConID = request.getParameter("ConID");
		String StaffID = request.getParameter("StaffID");
		String ConTime = request.getParameter("ConTime");
		String ConContent = request.getParameter("ConContent");
		String ConPos = request.getParameter("ConPos");
		
		
		
		ContactEntity se = new ContactEntity();
		se.setConID(ConID);
		se.setStaffID(StaffID);
		se.setConTime(toDate(ConTime));
		se.setConContent(ConContent);
		se.setConPos(ConPos);

		
	
		ContactDao sd = new ContactDao();
		
		if(sd.updateContact(se)){
			request.getRequestDispatcher("doQueryContact").forward(request, response);
		}else{
			
			request.setAttribute("errorMes", "ÐÞ¸ÄºÏÍ¬Ê§°Ü£¡");
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
