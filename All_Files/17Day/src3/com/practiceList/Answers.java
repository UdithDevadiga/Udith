package com.practiceList;

public class Answers {
	
	private int id;
	private String ans;
	private String by;
	
	public void setId(int id) {
		this.id=id;
	}
	
	public void setAns(String ans) {
		this.ans=ans;
	}
	
	public void setBy(String by) {
		this.by=by;
	}
	
	public int getID() {
		return id;
	}
	
	public String getAns() {
		return ans;
	}
	
	public String getBy() {
		return by;
	}
	
	public String toString() {
		return id+"\n"+ans+"\n"+by;
	}

}
