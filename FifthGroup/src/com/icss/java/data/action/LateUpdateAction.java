package com.icss.java.data.action;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.java.data.dao.LateDao;
import com.icss.java.data.dao.LateEntity;

public class LateUpdateAction extends HttpServlet {

	
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
		String arrivetime =request.getParameter("arrivetime");
		String reason = request.getParameter("reason");
		
		
		// ѧ��ʵ�����
		LateEntity la = new LateEntity();
		la.setstaffID(staffID);
		la.setName(Name);
		la.setarrivetime(toDate(arrivetime));// ���ַ���ת��Ϊ��������
		la.setreason(reason);
		
		// ѧ�����ݿ����DAO
		LateDao ld = new LateDao();
		 if(ld.updateUser(la)){
			// ��ת      ͨ��������ת��ҳ���Servlet
			request.getRequestDispatcher("doLateQueryAll").forward(request, response);
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


