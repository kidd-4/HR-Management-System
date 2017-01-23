package com.icss.java.data.dao;

import java.sql.Date;

public class LateEntity {
	private String staffID;
	private String Name;
	private Date arrivetime;
	private String reason;

	public String getstaffID() {
		return staffID;
	}
	public void setstaffID(String staffID) {
		this.staffID = staffID;
	}
	
		public String getName() {
		return Name;
	}
	public void setName(String Name) {
		this.Name = Name;
	}
	public Date getarrivetime() {
		return arrivetime;
	}
	public void setarrivetime(Date arrivetime) {
		this.arrivetime = arrivetime;
	}
	public String getreason() {
		return reason;
	}
	public void setreason(String reason) {
		this.reason = reason;
	}

	

}
