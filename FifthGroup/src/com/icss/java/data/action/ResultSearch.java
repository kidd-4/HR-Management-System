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

public class ResultSearch extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		//项目id，为空则全查找
		String id=request.getParameter("trainid");

		//员工姓名  name="" 则所有人
		String name=request.getParameter("name");
		System.out.println(name);
		
		
		MyClass.listResult=LyyDao.searchResult(id,name);
		
		
		
		request.setAttribute("isSearched", "1");
		request.getRequestDispatcher("resultscan.jsp").forward(request, response);
	}
	

}
