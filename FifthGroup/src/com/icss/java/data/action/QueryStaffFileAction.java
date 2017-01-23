package com.icss.java.data.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.java.data.dao.StaffDocumentDao;
import com.icss.java.data.dao.StaffDocumentEntity;
import com.icss.java.data.dao.StaffFileDao;
import com.icss.java.data.dao.StaffFileEntity;

public class QueryStaffFileAction extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// ��ʾ���е��û���Ϣ
		System.out.println("��ʾ����������Ϣ...");
		
		// �û����ݿ����DAO
		StaffFileDao sd = new StaffFileDao();
		
		//��������е��û���Ϣ
		List<StaffFileEntity> list = sd.queryAll();
		
		// �����ݵ����������
		request.setAttribute("stuList", list);
		
		// ��ת���û���ҳ
		request.getRequestDispatcher("StaffFile.jsp").forward(request, response);
	}

}
