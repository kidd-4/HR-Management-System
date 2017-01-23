package com.icss.java.data.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.java.data.dao.AbsentDao;


public class AbsentLoginAction extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// ����������룬��ֹ��������
		request.setCharacterEncoding("UTF-8");
		
		// ͨ���������request���ҳ�����ֵ
		String userId = request.getParameter("userID");
		String userPassword = request.getParameter("userPassword");
		
		System.out.println("userID:"+userId);
		System.out.println("userPassword:"+userPassword);
		
		// ѧ�����ݿ����DAO
		AbsentDao dd = new AbsentDao();
		
		// ���õ�¼����
		//if(la.loginUser(userId, userPassword)){
			System.out.println(userId+"��¼�ɹ���");
			
			// ��ת      ͨ��������ת��ҳ���Servlet
			request.getRequestDispatcher("doQueryAbsent").forward(request, response);
			
		//}else{
			//System.out.println("�û�����������󣬵�¼ʧ�ܣ�");
			//request.setAttribute("errorMes", "�û�����������󣬵�¼ʧ�ܣ�");
			//request.getRequestDispatcher("error.jsp").forward(request, response);
		}

		
	}

	


