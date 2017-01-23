package com.icss.java.data.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.icss.java.util.DBUtile;
import com.icss.java.data.dao.ContactEntity;

public class ContactDao {
	/**
	 * 用户登录
	 * @param ID 账号
	 * @param Password 密码
	 * @return
	 */
	public boolean loginUser(String userID, String userPassword){
		boolean flag = false;
		
		Connection conn = DBUtile.getConn();
		
		String sql = " select * from basicinfor where userID=? and userPassword=?";
		System.out.println(sql);
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userID);
			pstmt.setString(2, userPassword);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				flag = true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return flag;
	}
	
	

	/**
	 * 查询所有合同信息
	 * @return
	 */
	public List<ContactEntity> queryContact(){
		List<ContactEntity> list = new ArrayList<ContactEntity>();
		Connection conn = DBUtile.getConn();
		String sql = "select * from StaffContact";

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				 String ConID =rs.getString(1);
				 String StaffID=rs.getString(2);
				 Date ConTime=rs.getDate(3);
				 String ConContent=rs.getString(4);
				 String ConPos=rs.getString(5);
				 
				
				 ContactEntity se = new ContactEntity();
				 se.setConID(ConID);
				 se.setStaffID(StaffID);
				 se.setConTime(ConTime);
				 se.setConContent(ConContent);
				 se.setConPos(ConPos);
				 list.add(se);	
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
        return list;
}
	
	
	
	/**
	 * 添加合同
	 * @param se
	 * @return
	 */
	public boolean addContact(ContactEntity se){
		boolean flag = false;
		Connection conn = DBUtile.getConn();

		String sql = "insert into StaffContact values(?,?,?,?,?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, se.getConID());
			pstmt.setString(2, se.getStaffID());
			pstmt.setDate(3, se.getConTime());
			pstmt.setString(4, se.getConContent());
			pstmt.setString(5, se.getConPos());


			int i = pstmt.executeUpdate();
			
			if(i>0){
				flag = true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return flag;
		
	}
	
	
	
	/**
	 * 修改指定合同
	 * @param se
	 * @return
	 */
	public boolean updateContact(ContactEntity se){
		boolean flag = false;
		Connection conn = DBUtile.getConn();
		String sql = "update StaffContact set StaffID=?,ConTime=?,ConContent=?,ConPos=? where ConID=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, se.getStaffID());
			pstmt.setDate(2, se.getConTime());
			pstmt.setString(3, se.getConContent());
			pstmt.setString(4, se.getConPos());
			pstmt.setString(5,se.getConID());
	
			int i = pstmt.executeUpdate();
			if(i>0){
				flag = true;
			}		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return flag;
		
	}
	
	
	
	
	/**
	 * 通过合同编号删除合同信息
	 * @param name
	 * @return
	 */
	public boolean deleteContact(String ConID){
		boolean flag = false;
		Connection conn = DBUtile.getConn();
		String sql = "delete from StaffContact where ConID=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,ConID);
			int i = pstmt.executeUpdate();
			if(i>0){
				flag = true;
			}			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return flag;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
     public static void main(String[] args){
 	                   
		ContactDao sd = new ContactDao();
		boolean flag = sd.loginUser("2", "123");
		
		if(flag){
			System.out.println("登录成功！");
	    }else{
		System.out.println("用户名或密码错误，登录失败！");
	   }
		List<ContactEntity> list = sd.queryContact();
		System.out.println("显示所有合同信息：");
		
		for (int i = 0; i < list.size(); i++) {
			ContactEntity se = list.get(i);
			System.out.println(se.getConID()+"-"+se.getStaffID()+"-"+se.getConTime()
					+"-"+se.getConContent()+"-"+se.getConPos());
			
			}
		*/
			
			
/*	
		//添加新合同       
		 ContactEntity se = new ContactEntity();
		 se.setConID("8");
		 se.setStaffID("8");
		 se.setConTime("2015-01-02");
		 se.setConContent("照顾好人员的日常饮食");
		 se.setConPos("开发人员");
		
		 boolean flag1 = sd.addContact(se);

		if(flag1){
			System.out.println("添加合同成功！");
		}else{
			System.out.println("添加合同失败！");
		}*/
		
	
	
/*		
		 //修改合同信息
		ContactEntity be = new ContactEntity();
		be.setStaffID("7");
		be.setConTime("2015-01-04");
		be.setConContent("照顾好公司人员的日常饮食");
		be.setConPos("后勤部");
		be.setConID("");
		boolean flag2 = sd.updateContact(be);
		if(flag2){
			System.out.println("修改成功！");
		}else{
			System.out.println("修改失败！");
		}*/
		
		
		
	
		
		
		
	}

