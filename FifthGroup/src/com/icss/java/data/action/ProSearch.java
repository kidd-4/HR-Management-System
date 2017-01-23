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

public class ProSearch extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		
		//项目id，为空则全查找
		String id=request.getParameter("trainid");
		//类别  all=全类别   0-....listCategory表下标
		String category=request.getParameter("category");
		//状态 0=全部   1=未开始   2正进行   3已结束
		//String condition=request.getParameter("condition");
		MyClass.listPro=LyyDao.searchPro(id, category);
		
		
		request.setAttribute("isSearched", "1");
		request.getRequestDispatcher("proscan.jsp").forward(request, response);
	}
	

}
