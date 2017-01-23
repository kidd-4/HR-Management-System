package com.icss.java.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtile {
	
	/**
	 * ��������ݿ�����
	 * @return
	 */
	public static Connection getConn(){
		Connection conn = null;
		try {
			// 1. ��������
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			
			// 2. ������ݿ�����==��ͨ��	IP
			
			// �����ַ��� jdbc:jtds:sqlserver://IP:�˿�/���ݿ���
			String url = "jdbc:jtds:sqlserver://172.20.3.73:1433/data";
			String user = "sa";// ���ݿ��˺�
			String password = "123456";// ���ݿ�����
			
			// ��ͨ��JAVA�����ݿ�ͨ�� == ������
			conn = DriverManager.getConnection(url, user, password);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
	
	
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// ������ݿ�����
		Connection conn=getConn();
		
		try {
			
			
			System.out.println("conn:"+conn);
			
			// 3. ���ݿ�SQL���==����
			String sql = "select * from  trainpro";
			
			// 4. ���ݿ��������			������conn������sql����pstmtִ����
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			// 5. ִ�в�ѯ���������ؽ��������
			ResultSet rs = pstmt.executeQuery();
			
			// 6. ������
			boolean flag = rs.next();// �ж��Ƿ�����һ��
			
			// ��֤���
			if(flag){
				System.out.println("��¼�ɹ���");
			}else{
				System.out.println("�û�����������󣬵�¼ʧ�ܣ�");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		

	}

}
