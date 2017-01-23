package com.icss.java.data.action;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.icss.java.data.dao.DepartDao;
import com.icss.java.data.dao.DepartEntity;

public class DeleteDepartAction extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		
		String stuId = request.getParameter("stuId");
		stuId = new String(stuId.getBytes("iso-8859-1"),"utf-8");
		System.out.println("stuId:"+stuId);
		
		
		DepartDao sd = new DepartDao();
		
		if(sd.deleteDepart(stuId)){
			
			request.getRequestDispatcher("doQueryDepart").forward(request, response);
		}else{
			
			
			request.setAttribute("errorMes", "É¾³ý²¿ÃÅÊ§°Ü£¡");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
		
	}

}