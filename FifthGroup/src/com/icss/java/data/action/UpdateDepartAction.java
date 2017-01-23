package com.icss.java.data.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.java.data.dao.DepartDao;
import com.icss.java.data.dao.DepartEntity;

public class UpdateDepartAction extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
	
		String name = request.getParameter("name");
		String ID = request.getParameter("ID");
		String Pos = request.getParameter("Pos");
		String workContent = request.getParameter("workContent");
		
		DepartEntity se = new DepartEntity();
		se.setName(name);
		se.setID(ID);
		se.setPos(Pos);
		se.setWorkContent(workContent);

	
		DepartDao sd = new DepartDao();
		
		if(sd.updateDepart(se)){
		
			request.getRequestDispatcher("doQueryDepart").forward(request, response);
		}else{
			request.setAttribute("errorMes", "ÐÞ¸Ä²¿ÃÅÊ§°Ü£¡");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
		
	}

}
