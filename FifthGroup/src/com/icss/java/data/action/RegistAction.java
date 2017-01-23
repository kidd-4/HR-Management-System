package com.icss.java.data.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.java.data.dao.UserDao;
import com.icss.java.data.dao.UserEntity;
public class RegistAction extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
		
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 设置请求编码，防止中文乱码
		request.setCharacterEncoding("UTF-8");
		
		// 通过请求对象request获得页面参数值
		String userID = request.getParameter("userID");
		String userPassword1 = request.getParameter("userPassword1");
		String userPassword2 = request.getParameter("userPassword2");
		String userName = request.getParameter("userName");
		String userSex = request.getParameter("userSex");
		String userTel = request.getParameter("userTel");
		String userBirth = request.getParameter("userBirth");
		String userMail = request.getParameter("userMail");
		String userAdd = request.getParameter("userAdd");
		String userCard = request.getParameter("userCard");
		String userDep = request.getParameter("userDep");
		String userPos = request.getParameter("userPos");
		String userDesc = request.getParameter("userDesc");
		
		// 学生实体对象
		UserEntity se = new UserEntity();
		se.setUserID(userID);
		se.setUserPassword(userPassword1);
		se.setUserName(userName);
		se.setUserSex(userSex);
		se.setUserTel(userTel);
		
		// yyyy-MM-dd
		se.setUserBirth(toDate(userBirth));
		se.setUserMail(userMail);
		se.setUserAdd(userAdd);
		se.setUserCard(userCard);
		se.setUserDep(userDep);
		se.setUserPos(userPos);
		se.setUserDesc(userDesc);
		
		// 学生数据库操作DAO
		UserDao sd = new UserDao();
		
		if(sd.addUser(se)){
			// 跳转      通过请求跳转到页面或Servlet
			request.getRequestDispatcher("doQueryAll").forward(request, response);
		}else{
			// 绑定错误信息到请求中
			request.setAttribute("errorMes", "注册用户失败！");
			request.getRequestDispatcher("error.jsp").forward(request, response);
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
