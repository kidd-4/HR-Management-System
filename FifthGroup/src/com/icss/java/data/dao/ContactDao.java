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
	 * �û���¼
	 * @param ID �˺�
	 * @param Password ����
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
	 * ��ѯ���к�ͬ��Ϣ
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
	 * ��Ӻ�ͬ
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
	 * �޸�ָ����ͬ
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
	 * ͨ����ͬ���ɾ����ͬ��Ϣ
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
			System.out.println("��¼�ɹ���");
	    }else{
		System.out.println("�û�����������󣬵�¼ʧ�ܣ�");
	   }
		List<ContactEntity> list = sd.queryContact();
		System.out.println("��ʾ���к�ͬ��Ϣ��");
		
		for (int i = 0; i < list.size(); i++) {
			ContactEntity se = list.get(i);
			System.out.println(se.getConID()+"-"+se.getStaffID()+"-"+se.getConTime()
					+"-"+se.getConContent()+"-"+se.getConPos());
			
			}
		*/
			
			
/*	
		//����º�ͬ       
		 ContactEntity se = new ContactEntity();
		 se.setConID("8");
		 se.setStaffID("8");
		 se.setConTime("2015-01-02");
		 se.setConContent("�չ˺���Ա���ճ���ʳ");
		 se.setConPos("������Ա");
		
		 boolean flag1 = sd.addContact(se);

		if(flag1){
			System.out.println("��Ӻ�ͬ�ɹ���");
		}else{
			System.out.println("��Ӻ�ͬʧ�ܣ�");
		}*/
		
	
	
/*		
		 //�޸ĺ�ͬ��Ϣ
		ContactEntity be = new ContactEntity();
		be.setStaffID("7");
		be.setConTime("2015-01-04");
		be.setConContent("�չ˺ù�˾��Ա���ճ���ʳ");
		be.setConPos("���ڲ�");
		be.setConID("");
		boolean flag2 = sd.updateContact(be);
		if(flag2){
			System.out.println("�޸ĳɹ���");
		}else{
			System.out.println("�޸�ʧ�ܣ�");
		}*/
		
		
		
	
		
		
		
	}

