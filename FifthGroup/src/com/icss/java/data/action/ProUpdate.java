package com.icss.java.data.action;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.icss.java.data.dao.LyyDao;
import com.icss.java.data.dao.TrainPro;
import com.icss.java.lyy.MyClass;

public class ProUpdate extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id=request.getParameter("id");
		String category=request.getParameter("categoryid");//id
		Date startdate=toDate(request.getParameter("startdate"));
		Date enddate=toDate(request.getParameter("enddate"));
		
		
		System.out.println(startdate);
		
		
		
		String change=request.getParameter("change");
		
		
		TrainPro tp=new TrainPro(id,category,startdate,enddate);
		
		
		if(change.compareTo("1")==0){
			//修改培训项目成绩信息
			if(LyyDao.update(tp, tp.getClass())>0)
			{
				//修改成功
				request.getRequestDispatcher("proscan.jsp").forward(request, response);
			}else
			{
				//修改失败
				request.setAttribute("errorMes", "修改失败了，把信息好好填行吗？");
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
			
		}else
		{
			//添加培训项目
		
			
			
			
			try {
				
				if(LyyDao.insert(tp,tp.getClass())>0){
					//添加成功
					request.getRequestDispatcher("proscan.jsp").forward(request, response);
				
				}else{
					//添加失败
					request.setAttribute("errorMes", "添加失败了，能不能打对信息？");
					request.getRequestDispatcher("error.jsp").forward(request, response);
					
				}
				
				
				
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
