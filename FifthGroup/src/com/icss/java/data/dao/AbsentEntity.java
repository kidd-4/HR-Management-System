package com.icss.java.data.dao;

import java.sql.Date;


public class AbsentEntity {
	private String staffID;
	private String Name;
	private Date absenttime;
	private String reason;
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
	public Date getAbsenttime() {
		return absenttime;
	}
	public void setAbsenttime(Date absenttime) {
		this.absenttime = absenttime;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	


	

}
