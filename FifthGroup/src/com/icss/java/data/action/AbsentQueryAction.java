package com.icss.java.data.action;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.java.data.dao.AbsentDao;
import com.icss.java.data.dao.AbsentEntity;


public class AbsentQueryAction extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// ��ʾ���е��û���Ϣ
		System.out.println("��ʾ���л���Ϣ...");
		
		// �û����ݿ����DAO
		AbsentDao dd = new AbsentDao();
		
		//��������е��û���Ϣ
		List<AbsentEntity> list = dd.queryAll();
		// �����ݵ����������

		request.setAttribute("stuList", list);
		
		// ��ת���û���ҳ
		request.getRequestDispatcher("AbsentRecord.jsp").forward(request, response);
		
	}

}