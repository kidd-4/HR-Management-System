package com.icss.java.data.action;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.java.data.dao.DayoffDao;
import com.icss.java.data.dao.DayoffEntity;

public class DayoffUpdateAction extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ����������룬��ֹ��������
		request.setCharacterEncoding("UTF-8");
		// ͨ���������request���ҳ�����ֵ
		String staffID = request.getParameter("staffID");
		String Name = request.getParameter("Name");
		String dayofftime =request.getParameter("dayofftime");
		String span = request.getParameter("span");
		String reason = request.getParameter("reason");
		String status = request.getParameter("status");
		
		
		

		// ѧ��ʵ�����
		DayoffEntity de = new DayoffEntity();
		de.setStaffID(staffID);
		de.setName(Name);
		de.setDayofftime(toDate(dayofftime));// ���ַ���ת��Ϊ��������
		de.setSpan(span);
		de.setReason(reason);
		de.setStatus(status);

		// ѧ�����ݿ����DAO
		DayoffDao dd = new DayoffDao();
		 if(dd.updateUser(de)){
			// ��ת      ͨ��������ת��ҳ���Servlet
			request.getRequestDispatcher("doDayoffQueryAll").forward(request, response);
		}else{
			
			// �󶨴�����Ϣ��������
			request.setAttribute("errorMes", "�޸��û�ʧ�ܣ�");
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
