package com.icss.java.data.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.java.data.dao.StaffDocumentDao;
import com.icss.java.data.dao.StaffDocumentEntity;
import com.icss.java.data.dao.StaffFileDao;
import com.icss.java.data.dao.StaffFileEntity;

public class UpdateStaffFileAction extends HttpServlet {


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
		String staffID= request.getParameter("staffID");
		String pos = request.getParameter("pos");
		String dep = request.getParameter("dep");
		String edu = request.getParameter("edu");
		String workex = request.getParameter("workEx");
		
		
		// ѧ��ʵ�����
		StaffFileEntity se = new StaffFileEntity();
		se.setDocID(docID);
		se.setStaffID(staffID);
		se.setPos(pos);
		se.setDep(dep);
		se.setEdu(edu);
		se.setWorkEx(workex);
	
		System.out.println("docID"+docID+"staffID"+staffID+"pos"+pos+"dep"+dep+"edu"+edu+"workex"+workex);
		
		
		
		// ѧ�����ݿ����DAO
		StaffFileDao sd = new StaffFileDao();
		
		if(sd.updateStaffFile(se)){
			// ��ת      ͨ��������ת��ҳ���Servlet
			request.getRequestDispatcher("doQueryAll3").forward(request, response);
		}else{
			// �󶨴�����Ϣ��������
			request.setAttribute("errorMes", "�޸�Ա������ʧ�ܣ�");
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
