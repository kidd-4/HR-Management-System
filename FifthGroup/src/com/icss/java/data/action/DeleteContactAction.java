package com.icss.java.data.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.icss.java.data.dao.ContactDao;
import com.icss.java.data.dao.ContactEntity;

public class DeleteContactAction extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		
		String stuId = request.getParameter("stuId");
		System.out.println("stuId:"+stuId);
		
		
		ContactDao sd = new ContactDao();
		
		if(sd.deleteContact(stuId)){
			
			request.getRequestDispatcher("doQueryContact").forward(request, response);
		}else{
			
			
			request.setAttribute("errorMes", "É¾³ýÊ§°Ü£¡");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
		
	}

}