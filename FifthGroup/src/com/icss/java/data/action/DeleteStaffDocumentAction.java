package com.icss.java.data.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.java.data.dao.StaffDocumentDao;
import com.icss.java.data.dao.UserDao;

public class DeleteStaffDocumentAction extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ����������룬��ֹ��������
		request.setCharacterEncoding("UTF-8");
		
		// ͨ���������request���ҳ�����ֵ
		String docID = request.getParameter("docID");
		System.out.println("docID:"+docID);
		
		// ѧ�����ݿ����DAO
		StaffDocumentDao sd = new StaffDocumentDao();
		
		if(sd.deleteStaffDocument(docID)){
			// ��ת      ͨ��������ת��ҳ���Servlet
			request.getRequestDispatcher("doQueryAll2").forward(request, response);
		}else{
			
			// �󶨴�����Ϣ��������
			request.setAttribute("errorMes", "ɾ������ʧ�ܣ�");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
		
	}

}
