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
		
		//1. ������ Connection
		Connection conn = DBUtile.getConn();
		
		//2. ���� sql���
		//String sql = " select * from student where stuId='"+stuId+"' and stuPassword='"+stuPassword+"'";
		
		// ͨ��?ռλ���ķ�ʽ���ò���ֵ
		String sql = " select * from dayoff where staffID=? and userPassword=?";
		System.out.println(sql);
		

		try {
			//3. ִ���� PreparedStatement   �����߰������ִ����
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			//4. ���ò���ֵ
			pstmt.setString(1, userID);
			pstmt.setString(2, userPassword);
			
			
			//5. ִ���߿�ʼִ������ executeQuery
			ResultSet rs = pstmt.executeQuery();

			//6. �жϽ����ResultSet
			if(rs.next()){
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
	 * ��ѯ�����û���Ϣ
	 * @return
	 */
	public List<DayoffEntity> queryAll(){
		// �û����϶���
		List<DayoffEntity> list = new ArrayList<DayoffEntity>();
		
		//1. ������ Connection
		Connection conn = DBUtile.getConn();

		//2. ���� sql���
		String sql = "select * from dayoff";

		try {
			//3. ִ���� PreparedStatement   �����߰������ִ����
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			//4. ִ���߿�ʼִ������ executeQuery
			ResultSet rs = pstmt.executeQuery();
			
			//5. �жϽ����ResultSet
			while(rs.next()){
				 // ͨ���±������ݿ��е�ǰ�е���ֵ
				 String staffID =rs.getString(1);
				 String Name=rs.getString(2);
				 Date dayofftime=rs.getDate(3);
				 String span=rs.getString(4);
				 String reason=rs.getString(5);
				 String status=rs.getString(6);
				 

				 // ���������õ�ѧ��ʵ����
				 DayoffEntity de = new DayoffEntity();


    			 
				 de.setStaffID(staffID);
				 

    			 
    			 
				 de.setName(Name);
				 de.setDayofftime(dayofftime);
				 de.setSpan(span);
				 
				 de.setReason(reason);
				 de.setStatus(status);
				 
				 System.out.println(de.getReason());

				 System.out.println(reason);
				 
				 // ��ѧ����ӵ�������
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
	public boolean addUser(DayoffEntity de){
		boolean flag = false;
		//1. ������ Connection
		Connection conn = DBUtile.getConn();

		//2. ���� sql���
		String sql = "insert into dayoff values(?,?,?,?,?,?)";
		try {
			//3. ִ���� PreparedStatement   �����߰������ִ����
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			//4. ���ò���ֵ
			pstmt.setString(1, de.getStaffID());
			pstmt.setString(2, de.getName());
			pstmt.setDate(3, de.getDayofftime());
			pstmt.setString(4, de.getSpan());
			pstmt.setString(5, de.getReason());
			pstmt.setString(6, de.getStatus());
	
			
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
	public boolean updateUser(DayoffEntity de){
		boolean flag = false;
		//1. ������ Connection
		Connection conn = DBUtile.getConn();

		//2. ���� sql���
		String sql = "update dayoff set Name=?,dayofftime=?,Reason=?,span=?,status=? where staffID=?";
		try {
			//3. ִ���� PreparedStatement   �����߰������ִ����
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			//4. ���ò���ֵ
			pstmt.setString(6, de.getStaffID());
			pstmt.setString(1, de.getName());
			pstmt.setDate(2, de.getDayofftime());
			pstmt.setString(3, de.getReason());
			pstmt.setString(4, de.getSpan());
			pstmt.setString(5, de.getStatus());

			
			
			
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
	public boolean deleteUser(String staffID){
		boolean flag = false;
		//1. ������ Connection
		Connection conn = DBUtile.getConn();

		//2. ���� sql���
		String sql = "delete from dayoff where staffID=?";
		try {
			//3. ִ���� PreparedStatement   �����߰������ִ����
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			//4. ���ò���ֵ;
			pstmt.setString(1, staffID);
			
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
	 * @param args
	 */
	public static void main(String[] args) {
		
	
		
		
//		boolean flag = sd.loginUser("hama", "abc1234' or '1'='1");
//		// ��֤���
//		if(flag){
//			System.out.println("��¼�ɹ���");
//		}else{
//			System.out.println("�û�����������󣬵�¼ʧ�ܣ�");
//		}
//		
//		// ���ò�ѯ�����û���Ϣ����
//		List<StudentEntity> list = sd.queryAll();
//		System.out.println("��ʾ�����û���Ϣ��");
//		// ���������û���Ϣ
//		for (int i = 0; i < list.size(); i++) {
//			// ��ü������±��Ӧ������
//			StudentEntity se = list.get(i);
//			
//			System.out.println(se.getStuId()+"-"+se.getStuPassword()+"-"+se.getStuName()
//					+"-"+se.getStuSex()+"-"+se.getStuTel()+"-"+se.getStuAge()
//					+"-"+se.getStuAddress()+"-"+se.getStuTeacher()+"-"+se.getStuScore());
//			
//		}
//		 StudentEntity se = new StudentEntity();
//		 se.setStuId("hulumei");
//		 se.setStuAddress("��«ʡ��«�к�«ɽ1");
//		 se.setStuAge(21);
//		 se.setStuName("��«��1");
//		 se.setStuPassword("abc1231");
//		 se.setStuScore(100);
//		 se.setStuSex("��");
//		 se.setStuTeacher("old");
//		 se.setStuTel("13958547851");
		
//		 // ������������
//		boolean flag = sd.addUser(se);
//		
//		// ��֤�������
//		if(flag){
//			System.out.println("ע��ɹ���");
//		}else{
//			System.out.println("ע��ʧ�ܣ�");
//		}
		 
//		 // ������������
//			boolean flag = sd.updateUser(se);
//			
//			// ��֤�������
//			if(flag){
//				System.out.println("�޸ĳɹ���");
//			}else{
//				System.out.println("�޸�ʧ�ܣ�");
//			}
		
		
		// ������������
//		boolean flag = dd.deleteUser("����Ө");
//		
//		// ��֤�������
//		if(flag){
//			System.out.println("ɾ���ɹ���");
//		}else{
//			System.out.println("ɾ��ʧ�ܣ�");
//		}
			
	}

}