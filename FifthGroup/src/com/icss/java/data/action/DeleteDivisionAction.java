package com.icss.java.data.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.java.data.dao.divisionDao;
import com.icss.java.data.dao.divisionEntity;

public class DeleteDivisionAction extends HttpServlet {

	
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
		System.out.println("staffID:"+staffID);
		
		// ѧ�����ݿ����DAO
		divisionDao sd = new divisionDao();
		
		if(sd.deleteUser(staffID)){
			// ��ת      ͨ��������ת��ҳ���Servlet
			request.getRequestDispatcher("doQueryDivision").forward(request, response);
		}else{
			
			// �󶨴�����Ϣ��������
			request.setAttribute("errorMes", "ɾ����Ϣʧ�ܣ�");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
		
	}

}
