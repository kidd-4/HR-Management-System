
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
import com.icss.java.data.dao.TrainResult;
import com.icss.java.lyy.MyClass;

public class ResultUpdate extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}
	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String trainid=request.getParameter("trainid");
		String name=request.getParameter("name");
		
		
		boolean flag=true;
		String st =request.getParameter("score");
		System.out.println(st);
		int score=0;
		try{
			score=Integer.parseInt(st);
		}catch (Exception e){
			flag=false;
		}
		
		
		String change=request.getParameter("change");
		
	
		
		TrainResult tr=new TrainResult(trainid,LyyDao.getUserId(name),score);
		if(change.compareTo("1")==0){
			//修改培训项目成绩信息
			if(flag && LyyDao.update(tr, tr.getClass())>0)
			{
				//修改成功
				request.getRequestDispatcher("resultscan.jsp").forward(request, response);
			}else
			{
				//修改失败
				request.setAttribute("errorMes", "我也是醉了，修改都能失败？");
				request.getRequestDispatcher("error.jsp").forward(request, response);
			}
			
		}else
		{
			//添加培训 成绩
			try {
				
				if(flag && LyyDao.insert(tr,tr.getClass())>0){
					//添加成功
					request.getRequestDispatcher("resultscan.jsp").forward(request, response);
				
				}else{
					//添加失败
					request.setAttribute("errorMes", "添加都能失败，怕了怕了。");
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
