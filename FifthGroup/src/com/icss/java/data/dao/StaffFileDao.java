package com.icss.java.data.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.icss.java.util.DBUtile;

public class StaffFileDao {
	public List<StaffFileEntity> queryAll(){
		// 用户集合对象
		List<StaffFileEntity> list = new ArrayList<StaffFileEntity>();
		
		//1. 管理者 Connection
		Connection conn = DBUtile.getConn();

		//2. 任务 sql语句
		String sql = "select * from StaffFile";

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
				 String pos =rs.getString(3);
				 String dep =rs.getString(4);
				 String edu =rs.getString(5);
				 String workex =rs.getString(6);
				
				 
				
				 
				
			
				 
				
				 // 把数据设置到学生实体中
				 StaffFileEntity se = new StaffFileEntity();
				 se.setDocID(docID);
				 se.setStaffID(staffID);
				 se.setPos(pos);
				 se.setDep(dep);
				 se.setEdu(edu);
				 se.setWorkEx(workex);
				
				 
				 // 把学生添加到集合中
				 list.add(se);
				

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
	public boolean addStaffFile(StaffFileEntity se){
		boolean flag = false;
		//1. 管理者 Connection
		Connection conn = DBUtile.getConn();

		//2. 任务 sql语句
		String sql = "insert into StaffFile values(?,?,?,?,?,?)";
		try {
			//3. 执行者 PreparedStatement   管理者把任务给执行者
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			//4. 设置参数值
			pstmt.setString(1, se.getDocID());
			pstmt.setString(2, se.getStaffID());
			pstmt.setString(3, se.getPos());
			pstmt.setString(4, se.getDep());
			pstmt.setString(5, se.getEdu());
			pstmt.setString(6, se.getWorkEx());
			
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


	public boolean updateStaffFile(StaffFileEntity se){
		boolean flag = false;
		//1. 管理者 Connection
		Connection conn = DBUtile.getConn();

		//2. 任务 sql语句
		String sql = "update StaffFile set staffID=?,pos=?,dep=?,edu=?,workEx=? where docID=?";
		try {
			//3. 执行者 PreparedStatement   管理者把任务给执行者
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			//4. 设置参数值
			
			
			pstmt.setString(1, se.getStaffID());
			pstmt.setString(2, se.getPos());
			pstmt.setString(3, se.getDep());
			pstmt.setString(4, se.getEdu());
			pstmt.setString(5, se.getWorkEx());
			pstmt.setString(6, se.getDocID());

			
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
	public boolean deleteStaffFile(String docID){
		boolean flag = false;
		//1. 管理者 Connection
		Connection conn = DBUtile.getConn();

		//2. 任务 sql语句
		String sql = "delete from StaffFile where docID=?";
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
