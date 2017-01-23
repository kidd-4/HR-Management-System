package com.icss.java.data.dao;

import java.sql.Date;

public class ContactEntity {

	private String ConID;
	private String StaffID;
	private Date ConTime;
	private String ConContent;
	private String ConPos;
	
	
	
	
	public String getConID() {
		return ConID;
	}
	public void setConID(String conID) {
		ConID = conID;
	}
	
	
	public String getStaffID() {
		return StaffID;
	}
	public void setStaffID(String staffID) {
		StaffID = staffID;
	}
	
	
	public Date getConTime() {
		return ConTime;
	}
	public void setConTime(Date conTime) {
		ConTime = conTime;
	}
	
	
	public String getConContent() {
		return ConContent;
	}
	public void setConContent(String conContent) {
		ConContent = conContent;
	}
	
	
	public String getConPos() {
		return ConPos;
	}
	public void setConPos(String conPos) {
		ConPos = conPos;
	}
	
	
	
	
	
	
	
}
