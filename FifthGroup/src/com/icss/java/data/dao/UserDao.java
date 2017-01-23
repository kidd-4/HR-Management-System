package com.icss.java.data.dao;

import java.sql.Connection;


import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.icss.java.data.dao.UserDao;
import com.icss.java.data.dao.UserEntity;
import com.icss.java.util.DBUtile;

public class UserDao {
	public boolean loginUser(String userID, String userPassword){
		boolean flag = false;
		
		//1. 管理者 Connection
		Connection conn = DBUtile.getConn();
		
		//2. 任务 sql语句
		//String sql = " select * from student where stuId='"+stuId+"' and stuPassword='"+stuPassword+"'";
		
		// 通过?占位符的方式设置参数值
		String sql = " select * from basicinfor where userID=? and userPassword=?";
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
	public List<UserEntity> queryAll(){
		// 用户集合对象
		List<UserEntity> list = new ArrayList<UserEntity>();
		
		//1. 管理者 Connection
		Connection conn = DBUtile.getConn();

		//2. 任务 sql语句
		String sql = "select * from basicinfor";

		try {
			//3. 执行者 PreparedStatement   管理者把任务给执行者
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			//4. 执行者开始执行任务 executeQuery
			ResultSet rs = pstmt.executeQuery();
			
			//5. 判断结果集ResultSet
			while(rs.next()){
				 // 通过下标获得数据库中当前行的列值
				 String userID =rs.getString(1);
				 String userPassword=rs.getString(2);
				 String userName=rs.getString(3);
				 String userSex=rs.getString(4);
				 String userTel=rs.getString(5);
				 Date userBirth=rs.getDate(6);
				 String userMail=rs.getString(7);
				 String userAdd=rs.getString(8);
				 String userCard=rs.getString(9);
				 String userDep=rs.getString(10);
				 String userPos=rs.getString(11);
				 String userDesc=rs.getString(12);
				 
				
			
				 
				
				 // 把数据设置到学生实体中
				 UserEntity se = new UserEntity();
				 se.setUserID(userID);
				 se.setUserPassword(userPassword);
				 se.setUserName(userName);
				 se.setUserSex(userSex);
				 se.setUserTel(userTel);
				 se.setUserBirth(userBirth);
				 se.setUserMail(userMail);
				 se.setUserAdd(userAdd);
				 se.setUserCard(userCard);
				 se.setUserDep(userDep);
				 se.setUserPos(userPos);
				 se.setUserDesc(userDesc);
				 
				 // 把学生添加到集合中
				 list.add(se);
				
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
	 * 用户注册
	 * @param se
	 * @return
	 */
	public boolean addUser(UserEntity se){
		boolean flag = false;
		//1. 管理者 Connection
		Connection conn = DBUtile.getConn();

		//2. 任务 sql语句
		String sql = "insert into basicinfor values(?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			//3. 执行者 PreparedStatement   管理者把任务给执行者
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			//4. 设置参数值
			pstmt.setString(1, se.getUserID());
			pstmt.setString(2, se.getUserPassword());
			pstmt.setString(3, se.getUserName());
			pstmt.setString(4, se.getUserSex());
			pstmt.setString(5, se.getUserTel());
			pstmt.setDate(6, se.getUserBirth());
			pstmt.setString(7, se.getUserMail());
			pstmt.setString(8, se.getUserAdd());
			pstmt.setString(9, se.getUserCard());
			pstmt.setString(10, se.getUserDep());
			pstmt.setString(11, se.getUserPos());
			pstmt.setString(12, se.getUserDesc());
			
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


	public boolean updateUser(UserEntity se){
		boolean flag = false;
		//1. 管理者 Connection
		Connection conn = DBUtile.getConn();

		//2. 任务 sql语句
		String sql = "update basicinfor set userPassword=?,userName=?," +
				"userSex=?,userTel=?,userBirth=?,userMail=?,userAdd=?,userCard=?," +
				"userDep=?,userPos=?,userDesc=? where userID=?";
		try {
			//3. 执行者 PreparedStatement   管理者把任务给执行者
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			//4. 设置参数值
			
			pstmt.setString(1, se.getUserPassword());
			pstmt.setString(2, se.getUserName());
			pstmt.setString(3, se.getUserSex());
			pstmt.setString(4, se.getUserTel());
			pstmt.setDate(5, se.getUserBirth());
			pstmt.setString(6, se.getUserMail());
			pstmt.setString(7, se.getUserAdd());
			pstmt.setString(8, se.getUserCard());
			pstmt.setString(9, se.getUserDep());
			pstmt.setString(10, se.getUserPos());
			pstmt.setString(11, se.getUserDesc());
			pstmt.setString(12, se.getUserID());
			
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
	public boolean deleteUser(String userID){
		boolean flag = false;
		//1. 管理者 Connection
		Connection conn = DBUtile.getConn();

		//2. 任务 sql语句
		String sql = "delete from basicinfor where userID=?";
		try {
			//3. 执行者 PreparedStatement   管理者把任务给执行者
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			//4. 设置参数值;
			pstmt.setString(1, userID);
			
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
		// TODO Auto-generated method stub
		
		UserDao sd = new UserDao();
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
		//boolean flag = sd.deleteUser("1");
		
		// 验证新增结果
	/*	if(flag){
			System.out.println("删除成功！");
		}else{
			System.out.println("删除失败！");
		}
	*/		
	}
}
