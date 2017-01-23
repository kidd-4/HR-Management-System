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
	 * ��ѯ���в�����Ϣ
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
	 * ��Ӳ���
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
	 * �޸�ָ��������Ϣ
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
	 * ͨ����������ɾ��������Ϣ
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
	
	

	
	
	
	
	
	
	
	
/*������*******************************************/
	public static void main(String[] args){
 	                    /**��ѯ**/
		DepartDao sd = new DepartDao();
		boolean flag = sd.loginUser("2", "123");
		
		if(flag){
			System.out.println("��¼�ɹ���");
	    }else{
		System.out.println("�û�����������󣬵�¼ʧ�ܣ�");
	   }
	List<DepartEntity> list = sd.queryAll();
	System.out.println("��ʾ���в�����Ϣ��");
	
	for (int i = 0; i < list.size(); i++) {
		DepartEntity se = list.get(i);
		System.out.println(se.getName()+"-"+se.getID()+"-"+se.getPos()
				+"-"+se.getWorkContent());
		
		}
	
	
	
	
	
	
	

	          //����²���       
	 DepartEntity se = new DepartEntity();
	 se.setName("���ڲ�");
	 se.setID("8");
	 se.setPos("���ڲ�����Ա��");
	 se.setWorkContent("�չ˺���Ա���ճ���ʳ");

	
	boolean flag1 = sd.addDepart(se);

	if(flag1){
		System.out.println("��Ӳ��ųɹ���");
	}else{
		System.out.println("��Ӳ���ʧ�ܣ�");
	}
	
	
	

	        //�޸Ĳ�����Ϣ
	DepartEntity be = new DepartEntity();
	be.setID("7");
	be.setPos("���ڲ�����Ա��");
	be.setWorkContent("�չ˺ù�˾��Ա���ճ���ʳ");
	be.setName("���ڲ�");
	boolean flag2 = sd.updateDepart(be);
	if(flag2){
		System.out.println("�޸ĳɹ���");
	}else{
		System.out.println("�޸�ʧ�ܣ�");
	}
	
	
	
	
	
	           //ɾ������
	boolean flag3 = sd.deleteDepart("���ڲ�");
	if(flag3){
		System.out.println("ɾ�����ųɹ���");
	}else{
		System.out.println("ɾ������ʧ�ܣ�");
	}
	
	
	
	}	
}
