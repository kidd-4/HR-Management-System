package com.icss.java.data.dao;

public class TrainResult {
	String trainid;
	String workerid;
	int score;
	public TrainResult(String trainid,String workerid,int score )
	{
		this.trainid=trainid;
		this.workerid=workerid;
		this.score=score;
	}
	public TrainResult( )
	{
	
	}
	public TrainResult(String trainid,String workerid)
	{
		this.trainid=trainid;
		this.workerid=workerid;
	}
	public String getTrainid() {
		return trainid;
	}
	public void setTrainid(String trainid) {
		this.trainid = trainid;
	}
	public String getWorkerid() {
		return workerid;
	}
	public void setWorkerid(String workerid) {
		this.workerid = workerid;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
}
