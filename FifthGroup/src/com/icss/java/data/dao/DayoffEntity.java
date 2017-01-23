package com.icss.java.data.dao;

import java.sql.Date;


public class DayoffEntity {
	private String staffID;
	private String Name;
	private Date dayofftime;
	private String span;
	private String reason;
	private String status;
	public String getStaffID() {
		return staffID;
	}
	public void setStaffID(String staffID) {
		

		
		this.staffID = staffID;

	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public Date getDayofftime() {
		return dayofftime;
	}
	public void setDayofftime(Date dayofftime) {
		this.dayofftime = dayofftime;
	}
	public String getSpan() {
		return span;
	}
	public void setSpan(String span) {
		this.span = span;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}


	

}
