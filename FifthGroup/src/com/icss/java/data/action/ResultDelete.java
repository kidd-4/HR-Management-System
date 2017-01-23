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
import com.icss.java.data.dao.TrainResult;
import com.icss.java.lyy.MyClass;

public class ResultDelete extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String trainid=request.getParameter("trainid");
		String workerid=request.getParameter("workerid");
		TrainResult tr=new TrainResult(trainid,workerid);
		if(LyyDao.delete(tr, tr.getClass())>0)
		{
			//删除成功
			request.getRequestDispatcher("resultscan.jsp").forward(request, response);
		}else
		{
			//删除失败
			request.setAttribute("errorMes", "唉，这都能删除失败。。");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
		
		
	}
	

}
