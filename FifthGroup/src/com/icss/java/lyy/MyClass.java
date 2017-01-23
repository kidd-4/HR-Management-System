package com.icss.java.lyy;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.icss.java.data.dao.LyyDao;
import com.icss.java.data.dao.TrainCategory;
import com.icss.java.data.dao.TrainPro;
import com.icss.java.data.dao.TrainResult;

public class MyClass {
	public static List<TrainPro> listPro = new ArrayList<TrainPro>();
	public static List<TrainResult> listResult = new ArrayList<TrainResult>();
	public static List<TrainCategory> listCategory = new ArrayList<TrainCategory>();
	public static void getListPro()
	{
		listPro.clear();
		TrainPro tp=new TrainPro();
		List<Object> list=LyyDao.queryAll(tp.getClass());
		for(int i=0;i<list.size();i++)
		{
			tp=(TrainPro)list.get(i);
			listPro.add(tp);
		}
		
	}
	public static void getListResult()
	{
		listResult.clear();
		TrainResult tp=new TrainResult();
		List<Object> list=LyyDao.queryAll(tp.getClass());
		for(int i=0;i<list.size();i++)
		{
			tp=(TrainResult)list.get(i);
			listResult.add(tp);
		}
		
	}
	public static void getListCategory()
	{
		listCategory.clear();
		TrainCategory tc=new TrainCategory();
		List<Object> list=LyyDao.queryAll(tc.getClass());
		for(int i=0;i<list.size();i++)
		{
			tc=(TrainCategory)list.get(i);
			listCategory.add(tc);
		}
	}
	public static Date toDate(String date) {   
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
		java.util.Date Date=new java.util.Date();
		try {
			Date = df.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}   
		Date result=new Date(Date.getTime()); 
		return  result;
	}
}
