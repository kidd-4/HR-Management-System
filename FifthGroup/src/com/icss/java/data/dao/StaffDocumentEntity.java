package com.icss.java.data.dao;

import java.sql.Date;

public class StaffDocumentEntity {
	private String DocID;               
	private String StaffID ;
	private String DocCon ;
	private Date DocTime ;
	public String getDocID() {
		return DocID;
	}
	public void setDocID(String docID) {
		DocID = docID;
	}
	public String getStaffID() {
		return StaffID;
	}
	public void setStaffID(String staffID) {
		StaffID = staffID;
	}
	public String getDocCon() {
		return DocCon;
	}
	public void setDocCon(String docCon) {
		DocCon = docCon;
	}
	public Date getDocTime() {
		return DocTime;
	}
	public void setDocTime(Date docTime) {
		DocTime = docTime;
	}

	
}
