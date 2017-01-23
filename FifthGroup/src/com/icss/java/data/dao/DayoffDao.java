package com.icss.java.data.dao;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.icss.java.util.DBUtile;

public class DayoffDao {

	public boolean loginUser(String userID, String userPassword){
		boolean flag = false;
		
		//1. 管理者 Connection
		Connection conn = DBUtile.getConn();
		
		//2. 任务 sql语句
		//String sql = " select * from student where stuId='"+stuId+"' and stuPassword='"+stuPassword+"'";
		
		// 通过?占位符的方式设置参数值
		String sql = " select * from dayoff where staffID=? and userPassword=?";
		System.out.println(sql);
		

		try {
			//3. 执行者 PreparedStatement   管理者把任务给执行者
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			//4. 设置参数值
			pstmt.setString(1, userID);
			pstmt.setString(2, userPassword);
			
			
			//5. 执行者开始执行任务 executeQuery
			ResultSet rs = pstmt.executeQuery();

			//6. 判断结果集ResultSet
			if(rs.next()){
				flag = true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				// 关闭连接
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return flag;
	}
	
	/**
	 * 查询所有用户信息
	 * @return
	 */
	public List<DayoffEntity> queryAll(){
		// 用户集合对象
		List<DayoffEntity> list = new ArrayList<DayoffEntity>();
		
		//1. 管理者 Connection
		Connection conn = DBUtile.getConn();

		//2. 任务 sql语句
		String sql = "select * from dayoff";

		try {
			//3. 执行者 PreparedStatement   管理者把任务给执行者
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			//4. 执行者开始执行任务 executeQuery
			ResultSet rs = pstmt.executeQuery();
			
			//5. 判断结果集ResultSet
			while(rs.next()){
				 // 通过下标获得数据库中当前行的列值
				 String staffID =rs.getString(1);
				 String Name=rs.getString(2);
				 Date dayofftime=rs.getDate(3);
				 String span=rs.getString(4);
				 String reason=rs.getString(5);
				 String status=rs.getString(6);
				 

				 // 把数据设置到学生实体中
				 DayoffEntity de = new DayoffEntity();


    			 
				 de.setStaffID(staffID);
				 

    			 
    			 
				 de.setName(Name);
				 de.setDayofftime(dayofftime);
				 de.setSpan(span);
				 
				 de.setReason(reason);
				 de.setStatus(status);
				 
				 System.out.println(de.getReason());

				 System.out.println(reason);
				 
				 // 把学生添加到集合中
				 list.add(de);

//				System.out.println(rs.getString(1)+"-"+rs.getString(2)+"-"+rs.getDate(3)
	//					+"-"+rs.getString(4)+"-"+rs.getString(5)+"-"+rs.getString(6)
	//					);
				 
				 
				 
			}

			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				// 关闭连接
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return list;
		
	}
	
	/**
	 * 用户注册
	 * @param se
	 * @return
	 */
	public boolean addUser(DayoffEntity de){
		boolean flag = false;
		//1. 管理者 Connection
		Connection conn = DBUtile.getConn();

		//2. 任务 sql语句
		String sql = "insert into dayoff values(?,?,?,?,?,?)";
		try {
			//3. 执行者 PreparedStatement   管理者把任务给执行者
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			//4. 设置参数值
			pstmt.setString(1, de.getStaffID());
			pstmt.setString(2, de.getName());
			pstmt.setDate(3, de.getDayofftime());
			pstmt.setString(4, de.getSpan());
			pstmt.setString(5, de.getReason());
			pstmt.setString(6, de.getStatus());
	
			
			//5. 执行操作 【executeUpdate==增加、删除、修改】 i所影响的行数
			int i = pstmt.executeUpdate();
			
			// 插入结果进行判断
			if(i>0){
				flag = true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				// 关闭连接
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return flag;
		
	}
	
	/**
	 * 修改指定用户信息
	 * @param se
	 * @return
	 */
	public boolean updateUser(DayoffEntity de){
		boolean flag = false;
		//1. 管理者 Connection
		Connection conn = DBUtile.getConn();

		//2. 任务 sql语句
		String sql = "update dayoff set Name=?,dayofftime=?,Reason=?,span=?,status=? where staffID=?";
		try {
			//3. 执行者 PreparedStatement   管理者把任务给执行者
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			//4. 设置参数值
			pstmt.setString(6, de.getStaffID());
			pstmt.setString(1, de.getName());
			pstmt.setDate(2, de.getDayofftime());
			pstmt.setString(3, de.getReason());
			pstmt.setString(4, de.getSpan());
			pstmt.setString(5, de.getStatus());

			
			
			
			//5. 执行操作 【executeUpdate==增加、删除、修改】 i所影响的行数
			int i = pstmt.executeUpdate();
			
			// 插入结果进行判断
			if(i>0){
				flag = true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				// 关闭连接
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return flag;
		
	}
	
	/**
	 * 通过用户编号删除用户信息
	 * @param stuId
	 * @return
	 */
	public boolean deleteUser(String staffID){
		boolean flag = false;
		//1. 管理者 Connection
		Connection conn = DBUtile.getConn();

		//2. 任务 sql语句
		String sql = "delete from dayoff where staffID=?";
		try {
			//3. 执行者 PreparedStatement   管理者把任务给执行者
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			//4. 设置参数值;
			pstmt.setString(1, staffID);
			
			//5. 执行操作 【executeUpdate==增加、删除、修改】 i所影响的行数
			int i = pstmt.executeUpdate();
			
			// 插入结果进行判断
			if(i>0){
				flag = true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				// 关闭连接
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return flag;
		
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	
		
		
//		boolean flag = sd.loginUser("hama", "abc1234' or '1'='1");
//		// 验证结果
//		if(flag){
//			System.out.println("登录成功！");
//		}else{
//			System.out.println("用户名或密码错误，登录失败！");
//		}
//		
//		// 调用查询所有用户信息方法
//		List<StudentEntity> list = sd.queryAll();
//		System.out.println("显示所有用户信息：");
//		// 遍历所有用户信息
//		for (int i = 0; i < list.size(); i++) {
//			// 获得集合中下标对应的数据
//			StudentEntity se = list.get(i);
//			
//			System.out.println(se.getStuId()+"-"+se.getStuPassword()+"-"+se.getStuName()
//					+"-"+se.getStuSex()+"-"+se.getStuTel()+"-"+se.getStuAge()
//					+"-"+se.getStuAddress()+"-"+se.getStuTeacher()+"-"+se.getStuScore());
//			
//		}
//		 StudentEntity se = new StudentEntity();
//		 se.setStuId("hulumei");
//		 se.setStuAddress("葫芦省葫芦市葫芦山1");
//		 se.setStuAge(21);
//		 se.setStuName("葫芦妹1");
//		 se.setStuPassword("abc1231");
//		 se.setStuScore(100);
//		 se.setStuSex("男");
//		 se.setStuTeacher("old");
//		 se.setStuTel("13958547851");
		
//		 // 调用新增方法
//		boolean flag = sd.addUser(se);
//		
//		// 验证新增结果
//		if(flag){
//			System.out.println("注册成功！");
//		}else{
//			System.out.println("注册失败！");
//		}
		 
//		 // 调用新增方法
//			boolean flag = sd.updateUser(se);
//			
//			// 验证新增结果
//			if(flag){
//				System.out.println("修改成功！");
//			}else{
//				System.out.println("修改失败！");
//			}
		
		
		// 调用新增方法
//		boolean flag = dd.deleteUser("王婉莹");
//		
//		// 验证新增结果
//		if(flag){
//			System.out.println("删除成功！");
//		}else{
//			System.out.println("删除失败！");
//		}
			
	}

}