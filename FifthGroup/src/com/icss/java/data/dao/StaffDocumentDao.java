package com.icss.java.data.dao;

import java.sql.Connection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.icss.java.util.DBUtile;

public class StaffDocumentDao {
	public List<StaffDocumentEntity> queryAll(){
		// 用户集合对象
		List<StaffDocumentEntity> list = new ArrayList<StaffDocumentEntity>();
		
		//1. 管理者 Connection
		Connection conn = DBUtile.getConn();

		//2. 任务 sql语句
		String sql = "select * from StaffDocument";

		try {
			//3. 执行者 PreparedStatement   管理者把任务给执行者
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			//4. 执行者开始执行任务 executeQuery
			ResultSet rs = pstmt.executeQuery();
			
			//5. 判断结果集ResultSet
			while(rs.next()){
				 // 通过下标获得数据库中当前行的列值
				 String docID =rs.getString(1);
				 String staffID=rs.getString(2);
				 String docCon =rs.getString(3);
				 Date docTime=rs.getDate(4);
				
				 
				
			
				 
				
				 // 把数据设置到学生实体中
				 StaffDocumentEntity se = new StaffDocumentEntity();
				 se.setDocID(docID);
				 se.setStaffID(staffID);
				 se.setDocCon(docCon);
				 se.setDocTime(docTime);
				
				 
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
	public boolean addStaffDocument(StaffDocumentEntity se){
		boolean flag = false;
		//1. 管理者 Connection
		Connection conn = DBUtile.getConn();

		//2. 任务 sql语句
		String sql = "insert into StaffDocument values(?,?,?,?)";
		try {
			//3. 执行者 PreparedStatement   管理者把任务给执行者
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			//4. 设置参数值
			pstmt.setString(1, se.getDocID());
			pstmt.setString(2, se.getStaffID());
			pstmt.setString(3, se.getDocCon());
			pstmt.setDate(4, se.getDocTime());
			
			
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


	public boolean updateStaffDocument(StaffDocumentEntity se){
		boolean flag = false;
		//1. 管理者 Connection
		Connection conn = DBUtile.getConn();

		//2. 任务 sql语句
		String sql = "update StaffDocument set staffID=?,docCon=?," +
				"docTime=? where docID=?";
		try {
			//3. 执行者 PreparedStatement   管理者把任务给执行者
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			//4. 设置参数值
			
			
			pstmt.setString(1, se.getStaffID());
			pstmt.setString(2, se.getDocCon());
			pstmt.setDate(3, se.getDocTime());
			pstmt.setString(4, se.getDocID());
			
			
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
	public boolean deleteStaffDocument(String docID){
		boolean flag = false;
		//1. 管理者 Connection
		Connection conn = DBUtile.getConn();

		//2. 任务 sql语句
		String sql = "delete from StaffDocument where docID=?";
		try {
			//3. 执行者 PreparedStatement   管理者把任务给执行者
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			//4. 设置参数值;
			pstmt.setString(1, docID);
			
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
}
