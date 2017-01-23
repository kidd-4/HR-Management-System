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
	 * �û���¼
	 * @param stuId �˺�
	 * @param stuPassword ����
	 * @return
	 */
	public boolean loginUser(String staffId, String stuPassword){
		boolean flag = false;
		
		//1. ������ Connection
		Connection conn = DBUtile.getConn();
		
		//2. ���� sql���
		//String sql = " select * from student where stuId='"+stuId+"' and stuPassword='"+stuPassword+"'";
		
		// ͨ��?ռλ���ķ�ʽ���ò���ֵ
		String sql = " select * from division where staffID=? and stuPassword=?";
		System.out.println(sql);
		

		try {
			//3. ִ���� PreparedStatement   �����߰������ִ����
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			//4. ���ò���ֵ
			pstmt.setString(1, sql);        //aql֮ǰ��stuID
			pstmt.setString(2, stuPassword);
			
			
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
	public List<divisionEntity> queryAll(){
		// �û����϶���
		List<divisionEntity> list = new ArrayList<divisionEntity>();
		
		//1. ������ Connection
		Connection conn = DBUtile.getConn();

		//2. ���� sql���
		String sql = "select * from division";

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
				Date time=rs.getDate(3);
				String resaon=rs.getString(4);
				String category=rs.getString(5);
			
				 
				
				 // ���������õ�Ա��ʵ����
				divisionEntity di= new divisionEntity();
				 di.setStaffID(staffID);
				 di.setName(Name);
				 di.setTime(time);
				 di.setResaon(resaon);
				 di.setCategory(category);
				
				 
				 
				 // ��Ա����ӵ�������
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
	 * ���ӵ�����Ա
	 * @param se
	 * @return
	 */
	public boolean addUser(divisionEntity se){
		boolean flag = false;
		//1. ������ Connection
		Connection conn = DBUtile.getConn();

		//2. ���� sql���
		String sql = "insert into division values(?,?,?,?,?)";
		try {
			//3. ִ���� PreparedStatement   �����߰������ִ����
			PreparedStatement pstmt = conn.prepareStatement(sql);
			


			
			
			//4. ���ò���ֵ
			pstmt.setString(1, se.getStaffID());
			pstmt.setString(2, se.getName());
			pstmt.setDate(3, se.getTime());
			pstmt.setString(4, se.getResaon());
			pstmt.setString(5, se.getCategory());
		
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
	public boolean updateUser(divisionEntity se){
		boolean flag = false;
		//1. ������ Connection
		Connection conn = DBUtile.getConn();

		//2. ���� sql���
		String sql = "update division set Name=?,time=?,resaon=?,category=? where staffID=?";
		try {
			//3. ִ���� PreparedStatement   �����߰������ִ����
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			//4. ���ò���ֵ
			
			
			pstmt.setString(1, se.getName());
			pstmt.setDate(2, se.getTime());
			pstmt.setString(3, se.getResaon());
			pstmt.setString(4, se.getCategory());
			pstmt.setString(5, se.getStaffID());
			
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
		String sql = "delete from division where staffID=?";
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
	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		
		divisionDao sd = new divisionDao();
//		boolean flag = sd.loginUser("hama", "abc1234' or '1'='1");
//		// ��֤���
//		if(flag){
//			System.out.println("��¼�ɹ���");
//		}else{
//			System.out.println("�û�����������󣬵�¼ʧ�ܣ�");
//		}
//		
		// ���ò�ѯ�����û���Ϣ����
//		List<divisionEntity> list = sd.queryAll();
//		System.out.println("��ʾ�����û���Ϣ��");
//		// ���������û���Ϣ
//		for (int i = 0; i < list.size(); i++) {
//			// ��ü������±��Ӧ������
//			divisionEntity se = list.get(i);			
//			System.out.println(se.getStaffID()+"-"+se.getName()+"-"+se.getTime()
//					+"-"+se.getResaon()+"-"+se.getCategory());		
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
		
		
//		// ������������
//		boolean flag = sd.deleteUser("hulumei");
		
//		// ��֤�������
//		if(flag){
//			System.out.println("ɾ���ɹ���");
//		}else{
//			System.out.println("ɾ��ʧ�ܣ�");
		}
			
	}


