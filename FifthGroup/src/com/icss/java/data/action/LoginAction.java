package com.icss.java.data.action;

import java.io.IOException;


import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.java.data.dao.UserDao;

public class LoginAction extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// ����������룬��ֹ��������
		request.setCharacterEncoding("UTF-8");
		
		// ͨ���������request���ҳ�����ֵ
		String userID = request.getParameter("userID");
		String userPassword = request.getParameter("userPassword");
		
		System.out.println("userID:"+userID);
		System.out.println("userPassword:"+userPassword);
		
		// ѧ�����ݿ����DAO
		UserDao sd = new UserDao();
		
		// ���õ�¼����
		if(sd.loginUser(userID, userPassword)){
			System.out.println(userID+"��¼�ɹ���");
			
			// ��ת      ͨ��������ת��ҳ���Servlet
			request.getRequestDispatcher("index.htm").forward(request, response);
			
		}else{
			System.out.println("�û�����������󣬵�¼ʧ�ܣ�");
			request.setAttribute("errorMes", "�û�����������󣬵�¼ʧ�ܣ�");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}

		
	
	}

}
