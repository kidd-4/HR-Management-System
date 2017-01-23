package com.icss.java.data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.icss.java.data.dao.DepartEntity;
import com.icss.java.util.DBUtile;

public class DepartDao {

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
	 * 查询所有部门信息
	 * @return
	 */
	public List<DepartEntity> queryAll(){
		List<DepartEntity> list = new ArrayList<DepartEntity>();
		Connection conn = DBUtile.getConn();
		String sql = "select * from DepMan";

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				 String name =rs.getString(1);
				 String ID=rs.getString(2);
				 String Pos=rs.getString(3);
				 String workContent=rs.getString(4);
				 
				
				 DepartEntity se = new DepartEntity();
				 se.setName(name);
				 se.setID(ID);
				 se.setPos(Pos);
				 se.setWorkContent(workContent);
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
	 * 添加部门
	 * @param se
	 * @return
	 */
	public boolean addDepart(DepartEntity se){
		boolean flag = false;
		Connection conn = DBUtile.getConn();

		String sql = "insert into DepMan values(?,?,?,?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, se.getName());
			pstmt.setString(2, se.getID());
			pstmt.setString(3, se.getPos());
			pstmt.setString(4, se.getWorkContent());

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
	 * 修改指定部门信息
	 * @param se
	 * @return
	 */
	public boolean updateDepart(DepartEntity se){
		boolean flag = false;
		Connection conn = DBUtile.getConn();
		String sql = "update DepMan set ID=?,Pos=?,workContent=? where name=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, se.getID());
			pstmt.setString(2, se.getPos());
			pstmt.setString(3, se.getWorkContent());
			pstmt.setString(4, se.getName());
	
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
	 * 通过部门名称删除部门信息
	 * @param name
	 * @return
	 */
	public boolean deleteDepart(String name){
		boolean flag = false;
		Connection conn = DBUtile.getConn();
		String sql = "delete from DepMan where name=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,name);
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
	
	

	
	
	
	
	
	
	
	
/*主程序*******************************************/
	public static void main(String[] args){
 	                    /**查询**/
		DepartDao sd = new DepartDao();
		boolean flag = sd.loginUser("2", "123");
		
		if(flag){
			System.out.println("登录成功！");
	    }else{
		System.out.println("用户名或密码错误，登录失败！");
	   }
	List<DepartEntity> list = sd.queryAll();
	System.out.println("显示所有部门信息：");
	
	for (int i = 0; i < list.size(); i++) {
		DepartEntity se = list.get(i);
		System.out.println(se.getName()+"-"+se.getID()+"-"+se.getPos()
				+"-"+se.getWorkContent());
		
		}
	
	
	
	
	
	
	

	          //添加新部门       
	 DepartEntity se = new DepartEntity();
	 se.setName("后勤部");
	 se.setID("8");
	 se.setPos("后勤部长，员工");
	 se.setWorkContent("照顾好人员的日常饮食");

	
	boolean flag1 = sd.addDepart(se);

	if(flag1){
		System.out.println("添加部门成功！");
	}else{
		System.out.println("添加部门失败！");
	}
	
	
	

	        //修改部门信息
	DepartEntity be = new DepartEntity();
	be.setID("7");
	be.setPos("后勤部经理，员工");
	be.setWorkContent("照顾好公司人员的日常饮食");
	be.setName("后勤部");
	boolean flag2 = sd.updateDepart(be);
	if(flag2){
		System.out.println("修改成功！");
	}else{
		System.out.println("修改失败！");
	}
	
	
	
	
	
	           //删除部门
	boolean flag3 = sd.deleteDepart("后勤部");
	if(flag3){
		System.out.println("删除部门成功！");
	}else{
		System.out.println("删除部门失败！");
	}
	
	
	
	}	
}
