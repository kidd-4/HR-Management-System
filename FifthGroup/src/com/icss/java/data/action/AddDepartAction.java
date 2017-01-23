package com.icss.java.data.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.icss.java.data.dao.DepartDao;
import com.icss.java.data.dao.DepartEntity;

public class AddDepartAction extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ����������룬��ֹ��������
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		String ID = request.getParameter("ID");
		String Pos = request.getParameter("Pos");
		String workContent = request.getParameter("workContent");
		
		
		// ѧ��ʵ�����
		DepartEntity se = new DepartEntity();
		se.setName(name);
		se.setID(ID);
		se.setPos(Pos);
		se.setWorkContent(workContent);
		
		DepartDao sd = new DepartDao();
		
		if(sd.addDepart(se)){
			request.getRequestDispatcher("doQueryDepart").forward(request, response);
		}else{
			request.setAttribute("errorMes", "��Ӳ���ʧ�ܣ�");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
		
	}

}