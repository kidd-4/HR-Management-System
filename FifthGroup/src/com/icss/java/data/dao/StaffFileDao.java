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
		// �û����϶���
		List<StaffFileEntity> list = new ArrayList<StaffFileEntity>();
		
		//1. ������ Connection
		Connection conn = DBUtile.getConn();

		//2. ���� sql���
		String sql = "select * from StaffFile";

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
				 String pos =rs.getString(3);
				 String dep =rs.getString(4);
				 String edu =rs.getString(5);
				 String workex =rs.getString(6);
				
				 
				
				 
				
			
				 
				
				 // ���������õ�ѧ��ʵ����
				 StaffFileEntity se = new StaffFileEntity();
				 se.setDocID(docID);
				 se.setStaffID(staffID);
				 se.setPos(pos);
				 se.setDep(dep);
				 se.setEdu(edu);
				 se.setWorkEx(workex);
				
				 
				 // ��ѧ����ӵ�������
				 list.add(se);
				

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
	public boolean addStaffFile(StaffFileEntity se){
		boolean flag = false;
		//1. ������ Connection
		Connection conn = DBUtile.getConn();

		//2. ���� sql���
		String sql = "insert into StaffFile values(?,?,?,?,?,?)";
		try {
			//3. ִ���� PreparedStatement   �����߰������ִ����
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			//4. ���ò���ֵ
			pstmt.setString(1, se.getDocID());
			pstmt.setString(2, se.getStaffID());
			pstmt.setString(3, se.getPos());
			pstmt.setString(4, se.getDep());
			pstmt.setString(5, se.getEdu());
			pstmt.setString(6, se.getWorkEx());
			
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


	public boolean updateStaffFile(StaffFileEntity se){
		boolean flag = false;
		//1. ������ Connection
		Connection conn = DBUtile.getConn();

		//2. ���� sql���
		String sql = "update StaffFile set staffID=?,pos=?,dep=?,edu=?,workEx=? where docID=?";
		try {
			//3. ִ���� PreparedStatement   �����߰������ִ����
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			//4. ���ò���ֵ
			
			
			pstmt.setString(1, se.getStaffID());
			pstmt.setString(2, se.getPos());
			pstmt.setString(3, se.getDep());
			pstmt.setString(4, se.getEdu());
			pstmt.setString(5, se.getWorkEx());
			pstmt.setString(6, se.getDocID());

			
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
	public boolean deleteStaffFile(String docID){
		boolean flag = false;
		//1. ������ Connection
		Connection conn = DBUtile.getConn();

		//2. ���� sql���
		String sql = "delete from StaffFile where docID=?";
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
