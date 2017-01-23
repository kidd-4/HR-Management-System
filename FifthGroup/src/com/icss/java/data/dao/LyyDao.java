package com.icss.java.data.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.icss.java.lyy.MyClass;
import com.icss.java.util.DBUtile;


public class LyyDao {
		static public List<Object> queryAll(Object type)
		{
			List<Object> list = new ArrayList<Object>();
			Connection conn = DBUtile.getConn();
			String sql="";
			String name="";
			if(type==TrainCategory.class)
			{
				name="traincategory";
				sql = "select * from "+name;
			}
			else if(type==TrainPro.class)
			{
				name="trainpro";
				sql = "select * from "+name;
			}
			
			else //if(type==TrainResult.class)
			{
				name="trainresult";
				sql = "select * from "+name;
			}
			try {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next())
				{
					if(type==TrainCategory.class)
					{
						TrainCategory tc=new TrainCategory(
								rs.getString(1),
								rs.getString(2));
						list.add(tc);
					}
					else if(type==TrainPro.class)
					{
						TrainPro tc=new TrainPro(
								rs.getString(1),
								rs.getString(2),
								rs.getDate(3),
								rs.getDate(4)
						);
						list.add(tc);
					}
					
					else //if(type==TrainResult.class)
					{
						TrainResult tc=new TrainResult(
								rs.getString(1),
								rs.getString(2),
								rs.getInt(3)
						);
						list.add(tc);
					}
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
	
		static public List<TrainPro> queryAllPro()
		{
			List<TrainPro> list = new ArrayList<TrainPro>();
			Connection conn = DBUtile.getConn();
			String sql="";
			String name="";
			
				name="trainpro";
				sql = "select * from "+name;
			try {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next())
				{
					
						TrainPro tc=new TrainPro(
								rs.getString(1),
								rs.getString(2),
								rs.getDate(3),
								rs.getDate(4)
						);
						list.add(tc);
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
		static public List<TrainResult> queryAllResult()
		{
			List<TrainResult> list = new ArrayList<TrainResult>();
			Connection conn = DBUtile.getConn();
			String sql="";
			String name="";
			
			name="TrainResult";
			sql = "select * from "+name;
			try {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next())
				{
					
					TrainResult tc=new TrainResult(
								rs.getString(1),
								rs.getString(2),
								rs.getInt(3)
						);
						list.add(tc);
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
		static public List<TrainCategory> queryAllCategory()
		{
			List<TrainCategory> list = new ArrayList<TrainCategory>();
			Connection conn = DBUtile.getConn();
			String sql="";
			String name="";
			
			name="TrainCategory";
			sql = "select * from "+name;
			try {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next())
				{
					
					TrainCategory tc=new TrainCategory(
								rs.getString(1),
								rs.getString(2)
						);
						list.add(tc);
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
		

		
		public static int insert(Object object,Object type) throws SQLException {
			Connection conn=DBUtile.getConn();
			String name="";
			String sql="";
			if(type==TrainCategory.class)
			{
				name="traincategory";
				sql = "insert into "+name+" values(?,?)";
			}
			else if(type==TrainPro.class)
			{
				name="trainpro";
				sql = "insert into "+name+" values(?,?,?,?)";
			}
			
			else //if(type==TrainResult.class)
			{
				name="trainresult";
				sql = "insert into "+name+" values(?,?,?)";
			}
			PreparedStatement pstmt =conn.prepareStatement(sql);
			if(type==TrainCategory.class)
			{
				pstmt.setString(1,((TrainCategory)object).getId());
				pstmt.setString(2,((TrainCategory)object).getName());
			}
			else if(type==TrainPro.class)
			{
				pstmt.setString(1,((TrainPro)object).getId());
				pstmt.setString(2,((TrainPro)object).getCategory());
				pstmt.setDate(3,((TrainPro)object).getStartdate());
				pstmt.setDate(4,((TrainPro)object).getEnddate());
			}
			
			else //if(type==TrainResult.class)
			{
				pstmt.setString(1,((TrainResult)object).getTrainid());
				pstmt.setString(2,((TrainResult)object).getWorkerid());
				pstmt.setInt(3,((TrainResult)object).getScore());
			}
			try {
				int result = pstmt.executeUpdate();
				return result;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return 0;
		}
		public static int update(Object object,Object type) {
			Connection conn=DBUtile.getConn();
			String sql="";
			int result;
			if(type==TrainCategory.class)
			{
				try{
					sql = "update traincategory set name=? where (id=?)";
					PreparedStatement pstmt = conn.prepareStatement(sql);
					pstmt.setString(1,((TrainCategory)object).getName());
					result = pstmt.executeUpdate();
					return result;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if(type==TrainPro.class)
			{
				try{
					sql = "update TrainPro set category=?,startdate=?,enddate=? where (id=?)";
					PreparedStatement pstmt = conn.prepareStatement(sql);
					pstmt.setString(1,((TrainPro)object).getCategory());
					pstmt.setDate(2,((TrainPro)object).getStartdate());
					pstmt.setDate(3,((TrainPro)object).getEnddate());
					pstmt.setString(4,((TrainPro)object).getId());
					result = pstmt.executeUpdate();
					return result;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			else //if(type==TrainResult.class)
			{
				sql = "update TrainResult set score=? where (trainid=? and workerid=?)";
				try {
					PreparedStatement pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1,((TrainResult)object).getScore());
					pstmt.setString(2,((TrainResult)object).getTrainid());
					pstmt.setString(3,((TrainResult)object).getWorkerid());
					result = pstmt.executeUpdate();
					return result;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return 0;
		}
		public static int delete(Object object,Object type) {
			Connection conn=DBUtile.getConn();
			String sql="";
			int result;
			if(type==TrainCategory.class)
			{
				try{
					sql = "delete traincategory where (id=?)";
					PreparedStatement pstmt = conn.prepareStatement(sql);
					pstmt.setString(1,((TrainCategory)object).getId());
					result = pstmt.executeUpdate();
					return result;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if(type==TrainPro.class)
			{
				try{
					sql = "delete TrainPro where (id=?)";
					PreparedStatement pstmt = conn.prepareStatement(sql);
					pstmt.setString(1,((TrainPro)object).getId());
					result = pstmt.executeUpdate();
					return result;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			else //if(type==TrainResult.class)
			{
				sql = "delete TrainResult where (trainid=? and workerid=?)";
				try {
					PreparedStatement pstmt = conn.prepareStatement(sql);
					pstmt.setString(1,((TrainResult)object).getTrainid());
					pstmt.setString(2,((TrainResult)object).getWorkerid());
					result = pstmt.executeUpdate();
					return result;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return 0;
		}
		
		
		
		
		
		
		
		
		
		
		static public List<TrainPro> searchPro(String id,String category)
		{
			/*
			//项目id，为空则全查找
			String id=request.getParameter("trainid");
			//类别  all=全类别   0-....listCategory表下标
			String category=request.getParameter("category");
			//状态 0=全部   1=未开始   2正进行   3已结束
			String condition=request.getParameter("condition");
			*/
			
			List<TrainPro> list = new ArrayList<TrainPro>();
			Connection conn = DBUtile.getConn();
			
			//select * from trainpro where id like '%'

			String sql="select * from trainpro where ";
			if(id.compareTo("")==0 || id==null)
			{//查找所有id
				sql=sql+"id like '%' ";
			}else
			{
				sql=sql+"id="+id+" ";
			}
			if(category.compareTo("all")==0 )
			{//全类别,并不需要操作
				
			}
			else{//0-....listCategory表下标
				String categoryid=MyClass.listCategory.get(Integer.parseInt(category)).getId();
				sql=sql+" and category='"+categoryid+"' ";
			}
			try {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next())
				{
						TrainPro tc=new TrainPro(
								rs.getString(1),
								rs.getString(2),
								rs.getDate(3),
								rs.getDate(4)
						);
						list.add(tc);
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
		static public List<TrainResult> searchResult(String id ,String name)
		{
			/*
			//项目id，id==""则全查找
			String id=request.getParameter("trainid");
			//员工姓名  name="" 则所有人
			String name=request.getParameter("name");
			*/
			List<TrainResult> list = new ArrayList<TrainResult>();
			Connection conn = DBUtile.getConn();
			
			//select * from trainresult where trainid like '%'

			String sql="select * from trainresult where ";
			if(id.compareTo("")==0 || id==null)
			{//查找所有id
				sql=sql+"trainid like '%' ";
			}else
			{
				sql=sql+"trainid="+id+" ";
			}
			
			if(name.compareTo("")==0 || name==null)
			{//全姓名,并不需要操作
				
			}
			else{//只查找某人成绩
				String workerid=getUserId(name);
				sql=sql+" and workerid='"+workerid+"' ";
			}
			try {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next())
				{
					TrainResult tr=new TrainResult(
								rs.getString(1),
								rs.getString(2),
								rs.getInt(3)
						);
						list.add(tr);
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
		
		
		
		
		
		

		public static String getCategoryName(String id,Object type)
		{
			if(TrainCategory.class==type)
			{//id是categoryid
				Connection conn = DBUtile.getConn();
				String sql="";
				String name="";
				name="TrainCategory";
				sql = "select * from "+name+" where id=?";
				try {
					PreparedStatement pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, id);
					ResultSet rs = pstmt.executeQuery();
					if(rs.next())
					{
						return rs.getString(2);
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
			}else{//id是trainid id
				Connection conn = DBUtile.getConn();
				String sql="";
				String name="";
				name="TrainPro";
				sql = "select * from "+name+" where id=?";
				try {
					PreparedStatement pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, id);
					ResultSet rs = pstmt.executeQuery();
					if(rs.next())
					{
						id=rs.getString(2);
						
						
						name="TrainCategory";
						sql = "select * from "+name+" where id=?";
						pstmt = conn.prepareStatement(sql);
						pstmt.setString(1, id);
						rs = pstmt.executeQuery();
						if(rs.next())
						{
							return rs.getString(2);
						}
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
			}
			return null;
		}
		public static String getUserName(String id)
		{
			//表basicinfor，userid，username：3
			Connection conn = DBUtile.getConn();
			String sql="";
			String name="basicinfor";
			sql = "select * from "+name+" where userid=?";
			try {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, id);
				ResultSet rs = pstmt.executeQuery();
				if(rs.next())
				{
					return rs.getString(3);
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
			return null;
		}
		public static String getUserId(String name) {
			//表basicinfor，userid:1，username：3
			Connection conn = DBUtile.getConn();
			String sql="";
			sql = "select * from basicinfor where username=?";
			try {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, name);
				ResultSet rs = pstmt.executeQuery();
				if(rs.next())
				{
					return rs.getString(1);
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
			return null;
		}







}

