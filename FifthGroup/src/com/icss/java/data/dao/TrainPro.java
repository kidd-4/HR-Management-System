package com.icss.java.data.dao;

import java.sql.Date;

public class TrainPro {
	String id;
	String category;
	Date startdate;
	Date enddate;
	public TrainPro(String id,String category,Date startdate,Date enddate)
	{
		this.id=id;
		this.category=category;
		this.startdate=startdate;
		this.enddate=enddate;
	}
	public TrainPro()
	{
	}
	public TrainPro(String id)
	{this.id=id;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Date getStartdate() {
		return startdate;
	}
	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}
	public Date getEnddate() {
		return enddate;
	}
	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}
	
}
