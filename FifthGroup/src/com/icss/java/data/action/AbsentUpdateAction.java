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
		// ����������룬��ֹ��������
		request.setCharacterEncoding("UTF-8");
		// ͨ���������request���ҳ�����ֵ
		String staffID = request.getParameter("staffID");
		String Name = request.getParameter("Name");
		String absenttime =request.getParameter("absenttime");
		
		String reason = request.getParameter("reason");
		
		
		
		// ѧ��ʵ�����
		AbsentEntity de = new AbsentEntity();
		de.setStaffID(staffID);
		de.setName(Name);
		de.setAbsenttime(toDate(absenttime));// ���ַ���ת��Ϊ��������
	     de.setReason(reason);
				
		// ѧ�����ݿ����DAO
		AbsentDao dd = new AbsentDao();
		 if(dd.updateUser(de)){
			// ��ת      ͨ��������ת��ҳ���Servlet
			request.getRequestDispatcher("doQueryAbsent").forward(request, response);
		}else{
			
			// �󶨴�����Ϣ��������
			request.setAttribute("errorMes", "�޸�ȱ�ڼ�¼ʧ�ܣ�");
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

