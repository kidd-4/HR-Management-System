package com.icss.java.data.action;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.icss.java.data.dao.LyyDao;
import com.icss.java.data.dao.TrainPro;
import com.icss.java.lyy.MyClass;

public class ProDelete extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id=request.getParameter("id");
		TrainPro tp=new TrainPro(id);
		if(LyyDao.delete(tp, tp.getClass())>0)
		{
			//删除成功
			request.getRequestDispatcher("proscan.jsp").forward(request, response);
		}else
		{
			//删除失败
			request.setAttribute("errorMes", "删除失败。。。怪我咯？");
			request.getRequestDispatcher("error.jsp").forward(request, response);
			
		}
		
		
	}
	

}
