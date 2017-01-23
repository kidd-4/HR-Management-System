package com.icss.java.data.dao;

public class TrainCategory {
	String id;
	String name;
	public TrainCategory(String id,String name)
	{
		this.id=id;
		this.name=name;
	}
	public TrainCategory()
	{
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
