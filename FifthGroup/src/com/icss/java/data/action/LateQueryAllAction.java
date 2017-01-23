package com.icss.java.data.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.java.data.dao.LateDao;
import com.icss.java.data.dao.LateEntity;

public class LateQueryAllAction extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// ��ʾ���е��û���Ϣ
		System.out.println("��ʾ���л���Ϣ...");
		
		// �û����ݿ����DAO
		LateDao ld = new LateDao();
		
		//��������е��û���Ϣ
		List<LateEntity> list = ld.queryAll();
		// �����ݵ����������
		request.setAttribute("LateList", list);
		
		// ��ת���û���ҳ
		request.getRequestDispatcher("LateRecord.jsp").forward(request, response);
		
	}

}