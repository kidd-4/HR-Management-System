package com.icss.java.data.dao;


import java.sql.Connection;


import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.icss.java.util.DBUtile;


public class divisionDao {
	
	/**
	 * 用户登录
	 * @param stuId 账号
	 * @param stuPassword 密码
	 * @return
	 */
	public boolean loginUser(String staffId, String stuPassword){
		boolean flag = false;
		
		//1. 管理者 Connection
		Connection conn = DBUtile.getConn();
		
		//2. 任务 sql语句
		//String sql = " select * from student where stuId='"+stuId+"' and stuPassword='"+stuPassword+"'";
		
		// 通过?占位符的方式设置参数值
		String sql = " select * from division where staffID=? and stuPassword=?";
		System.out.println(sql);
		

		try {
			//3. 执行者 PreparedStatement   管理者把任务给执行者
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			//4. 设置参数值
			pstmt.setString(1, sql);        //aql之前是stuID
			pstmt.setString(2, stuPassword);
			
			
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
	public List<divisionEntity> queryAll(){
		// 用户集合对象
		List<divisionEntity> list = new ArrayList<divisionEntity>();
		
		//1. 管理者 Connection
		Connection conn = DBUtile.getConn();

		//2. 任务 sql语句
		String sql = "select * from division";

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
				Date time=rs.getDate(3);
				String resaon=rs.getString(4);
				String category=rs.getString(5);
			
				 
				
				 // 把数据设置到员工实体中
				divisionEntity di= new divisionEntity();
				 di.setStaffID(staffID);
				 di.setName(Name);
				 di.setTime(time);
				 di.setResaon(resaon);
				 di.setCategory(category);
				
				 
				 
				 // 把员工添加到集合中
				 list.add(di);
				
//				System.out.println(rs.getString(1)+"-"+rs.getString(2)+"-"+rs.getInt(3)
//						+"-"+rs.getString(4)+"-"+rs.getString(5)+"-"+rs.getString(6)
//						+"-"+rs.getString(7)+"-"+rs.getDouble(8)+"-"+rs.getString(9));
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
	 * 增加调配人员
	 * @param se
	 * @return
	 */
	public boolean addUser(divisionEntity se){
		boolean flag = false;
		//1. 管理者 Connection
		Connection conn = DBUtile.getConn();

		//2. 任务 sql语句
		String sql = "insert into division values(?,?,?,?,?)";
		try {
			//3. 执行者 PreparedStatement   管理者把任务给执行者
			PreparedStatement pstmt = conn.prepareStatement(sql);
			


			
			
			//4. 设置参数值
			pstmt.setString(1, se.getStaffID());
			pstmt.setString(2, se.getName());
			pstmt.setDate(3, se.getTime());
			pstmt.setString(4, se.getResaon());
			pstmt.setString(5, se.getCategory());
		
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
	public boolean updateUser(divisionEntity se){
		boolean flag = false;
		//1. 管理者 Connection
		Connection conn = DBUtile.getConn();

		//2. 任务 sql语句
		String sql = "update division set Name=?,time=?,resaon=?,category=? where staffID=?";
		try {
			//3. 执行者 PreparedStatement   管理者把任务给执行者
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			//4. 设置参数值
			
			
			pstmt.setString(1, se.getName());
			pstmt.setDate(2, se.getTime());
			pstmt.setString(3, se.getResaon());
			pstmt.setString(4, se.getCategory());
			pstmt.setString(5, se.getStaffID());
			
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
		String sql = "delete from division where staffID=?";
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
	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		
		divisionDao sd = new divisionDao();
//		boolean flag = sd.loginUser("hama", "abc1234' or '1'='1");
//		// 验证结果
//		if(flag){
//			System.out.println("登录成功！");
//		}else{
//			System.out.println("用户名或密码错误，登录失败！");
//		}
//		
		// 调用查询所有用户信息方法
//		List<divisionEntity> list = sd.queryAll();
//		System.out.println("显示所有用户信息：");
//		// 遍历所有用户信息
//		for (int i = 0; i < list.size(); i++) {
//			// 获得集合中下标对应的数据
//			divisionEntity se = list.get(i);			
//			System.out.println(se.getStaffID()+"-"+se.getName()+"-"+se.getTime()
//					+"-"+se.getResaon()+"-"+se.getCategory());		
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
		
		
//		// 调用新增方法
//		boolean flag = sd.deleteUser("hulumei");
		
//		// 验证新增结果
//		if(flag){
//			System.out.println("删除成功！");
//		}else{
//			System.out.println("删除失败！");
		}
			
	}


