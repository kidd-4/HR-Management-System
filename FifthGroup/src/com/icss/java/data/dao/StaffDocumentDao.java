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
		// �û����϶���
		List<StaffDocumentEntity> list = new ArrayList<StaffDocumentEntity>();
		
		//1. ������ Connection
		Connection conn = DBUtile.getConn();

		//2. ���� sql���
		String sql = "select * from StaffDocument";

		try {
			//3. ִ���� PreparedStatement   �����߰������ִ����
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			//4. ִ���߿�ʼִ������ executeQuery
			ResultSet rs = pstmt.executeQuery();
			
			//5. �жϽ����ResultSet
			while(rs.next()){
				 // ͨ���±������ݿ��е�ǰ�е���ֵ
				 String docID =rs.getString(1);
				 String staffID=rs.getString(2);
				 String docCon =rs.getString(3);
				 Date docTime=rs.getDate(4);
				
				 
				
			
				 
				
				 // ���������õ�ѧ��ʵ����
				 StaffDocumentEntity se = new StaffDocumentEntity();
				 se.setDocID(docID);
				 se.setStaffID(staffID);
				 se.setDocCon(docCon);
				 se.setDocTime(docTime);
				
				 
				 // ��ѧ����ӵ�������
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
				// �ر�����
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		
		return list;
		
	}
	
	/**
	 * �û�ע��
	 * @param se
	 * @return
	 */
	public boolean addStaffDocument(StaffDocumentEntity se){
		boolean flag = false;
		//1. ������ Connection
		Connection conn = DBUtile.getConn();

		//2. ���� sql���
		String sql = "insert into StaffDocument values(?,?,?,?)";
		try {
			//3. ִ���� PreparedStatement   �����߰������ִ����
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			//4. ���ò���ֵ
			pstmt.setString(1, se.getDocID());
			pstmt.setString(2, se.getStaffID());
			pstmt.setString(3, se.getDocCon());
			pstmt.setDate(4, se.getDocTime());
			
			
			//5. ִ�в��� ��executeUpdate==���ӡ�ɾ�����޸ġ� i��Ӱ�������
			int i = pstmt.executeUpdate();
			
			// �����������ж�
			if(i>0){
				flag = true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				// �ر�����
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return flag;
		
	}
	
	/**
	 * �޸�ָ���û���Ϣ
	 * @param se
	 * @return
	 */


	public boolean updateStaffDocument(StaffDocumentEntity se){
		boolean flag = false;
		//1. ������ Connection
		Connection conn = DBUtile.getConn();

		//2. ���� sql���
		String sql = "update StaffDocument set staffID=?,docCon=?," +
				"docTime=? where docID=?";
		try {
			//3. ִ���� PreparedStatement   �����߰������ִ����
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			//4. ���ò���ֵ
			
			
			pstmt.setString(1, se.getStaffID());
			pstmt.setString(2, se.getDocCon());
			pstmt.setDate(3, se.getDocTime());
			pstmt.setString(4, se.getDocID());
			
			
			//5. ִ�в��� ��executeUpdate==���ӡ�ɾ�����޸ġ� i��Ӱ�������
			int i = pstmt.executeUpdate();
			
			// �����������ж�
			if(i>0){
				flag = true;
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				// �ر�����
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return flag;
		
	}
	
	/**
	 * ͨ���û����ɾ���û���Ϣ
	 * @param stuId
	 * @return
	 */
	public boolean deleteStaffDocument(String docID){
		boolean flag = false;
		//1. ������ Connection
		Connection conn = DBUtile.getConn();

		//2. ���� sql���
		String sql = "delete from StaffDocument where docID=?";
		try {
			//3. ִ���� PreparedStatement   �����߰������ִ����
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			//4. ���ò���ֵ;
			pstmt.setString(1, docID);
			
			//5. ִ�в��� ��executeUpdate==���ӡ�ɾ�����޸ġ� i��Ӱ�������
			int i = pstmt.executeUpdate();
			
			// �����������ж�
			if(i>0){
				flag = true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				// �ر�����
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return flag;
}
}
