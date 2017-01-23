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
		
		//1. ������ Connection
		Connection conn = DBUtile.getConn();
		
		//2. ���� sql���
		//String sql = " select * from student where stuId='"+stuId+"' and stuPassword='"+stuPassword+"'";
		
		// ͨ��?ռλ���ķ�ʽ���ò���ֵ
		String sql = " select * from basicinfor where userID=? and userPassword=?";
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
	public List<UserEntity> queryAll(){
		// �û����϶���
		List<UserEntity> list = new ArrayList<UserEntity>();
		
		//1. ������ Connection
		Connection conn = DBUtile.getConn();

		//2. ���� sql���
		String sql = "select * from basicinfor";

		try {
			//3. ִ���� PreparedStatement   �����߰������ִ����
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			//4. ִ���߿�ʼִ������ executeQuery
			ResultSet rs = pstmt.executeQuery();
			
			//5. �жϽ����ResultSet
			while(rs.next()){
				 // ͨ���±������ݿ��е�ǰ�е���ֵ
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
				 
				
			
				 
				
				 // ���������õ�ѧ��ʵ����
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
	public boolean addUser(UserEntity se){
		boolean flag = false;
		//1. ������ Connection
		Connection conn = DBUtile.getConn();

		//2. ���� sql���
		String sql = "insert into basicinfor values(?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			//3. ִ���� PreparedStatement   �����߰������ִ����
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			//4. ���ò���ֵ
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


	public boolean updateUser(UserEntity se){
		boolean flag = false;
		//1. ������ Connection
		Connection conn = DBUtile.getConn();

		//2. ���� sql���
		String sql = "update basicinfor set userPassword=?,userName=?," +
				"userSex=?,userTel=?,userBirth=?,userMail=?,userAdd=?,userCard=?," +
				"userDep=?,userPos=?,userDesc=? where userID=?";
		try {
			//3. ִ���� PreparedStatement   �����߰������ִ����
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			//4. ���ò���ֵ
			
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
	public boolean deleteUser(String userID){
		boolean flag = false;
		//1. ������ Connection
		Connection conn = DBUtile.getConn();

		//2. ���� sql���
		String sql = "delete from basicinfor where userID=?";
		try {
			//3. ִ���� PreparedStatement   �����߰������ִ����
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			//4. ���ò���ֵ;
			pstmt.setString(1, userID);
			
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
		// TODO Auto-generated method stub
		
		UserDao sd = new UserDao();
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
		//boolean flag = sd.deleteUser("1");
		
		// ��֤�������
	/*	if(flag){
			System.out.println("ɾ���ɹ���");
		}else{
			System.out.println("ɾ��ʧ�ܣ�");
		}
	*/		
	}
}
