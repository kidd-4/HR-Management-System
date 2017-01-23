package com.icss.java.data.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.java.data.dao.ContactDao;
import com.icss.java.data.dao.ContactEntity;

public class QueryContactAction extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request,response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// ��ʾ���е��û���Ϣ
		System.out.println("��ʾ���к�ͬ��Ϣ");
		
		// �û����ݿ����DAO
		ContactDao sd = new ContactDao();
		
		//��������е��û���Ϣ
		List<ContactEntity> list = sd.queryContact();
		
		// �����ݵ����������
		request.setAttribute("stuList", list);
		
		// ��ת���û���ҳ
		request.getRequestDispatcher("queryContact.jsp").forward(request, response);
	}

}

