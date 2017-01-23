package com.icss.java.data.dao;

import java.sql.Date;

public class StaffFileEntity {
	private String DocID;   
	private String StaffID; 
	private String Pos ;
	private String Dep ;
	private String Edu ;
	private String workEx ;
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
	public String getPos() {
		return Pos;
	}
	public void setPos(String pos) {
		Pos = pos;
	}
	public String getDep() {
		return Dep;
	}
	public void setDep(String dep) {
		Dep = dep;
	}
	public String getEdu() {
		return Edu;
	}
	public void setEdu(String edu) {
		Edu = edu;
	}
	public String getWorkEx() {
		return workEx;
	}
	public void setWorkEx(String workEx) {
		this.workEx = workEx;
	}
	
	
	
}
