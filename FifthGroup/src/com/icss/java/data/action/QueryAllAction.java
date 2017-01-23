package com.icss.java.data.action;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.java.data.dao.UserDao;
import com.icss.java.data.dao.UserEntity;
import com.icss.java.data.dao.UserDao;
import com.icss.java.data.dao.UserEntity;

public class QueryAllAction extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��ʾ���е��û���Ϣ
		System.out.println("��ʾ�����û���Ϣ...");
		
		// �û����ݿ����DAO
		UserDao sd = new UserDao();
		
		//��������е��û���Ϣ
		List<UserEntity> list = sd.queryAll();
		
		// �����ݵ����������
		request.setAttribute("stuList", list);
		
		// ��ת���û���ҳ
		request.getRequestDispatcher("main.jsp").forward(request, response);
		
	}

}
