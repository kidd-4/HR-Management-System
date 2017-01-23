package com.icss.java.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtile {
	
	/**
	 * 获得是数据库连接
	 * @return
	 */
	public static Connection getConn(){
		Connection conn = null;
		try {
			// 1. 加载驱动
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			
			// 2. 获得数据库连接==挖通道	IP
			
			// 连接字符串 jdbc:jtds:sqlserver://IP:端口/数据库名
			String url = "jdbc:jtds:sqlserver://172.20.3.73:1433/data";
			String user = "sa";// 数据库账号
			String password = "123456";// 数据库密码
			
			// 打通了JAVA与数据库通道 == 管理者
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
		
		// 获得数据库连接
		Connection conn=getConn();
		
		try {
			
			
			System.out.println("conn:"+conn);
			
			// 3. 数据库SQL语句==任务
			String sql = "select * from  trainpro";
			
			// 4. 数据库操作对象			管理者conn把任务sql交给pstmt执行者
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			// 5. 执行查询操作，返回结果集对象
			ResultSet rs = pstmt.executeQuery();
			
			// 6. 处理结果
			boolean flag = rs.next();// 判断是否有下一行
			
			// 验证结果
			if(flag){
				System.out.println("登录成功！");
			}else{
				System.out.println("用户名或密码错误，登录失败！");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		

	}

}
