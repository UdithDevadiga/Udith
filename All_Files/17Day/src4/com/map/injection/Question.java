package com.map.injection;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Question {
	
	private int id;
	private String name;
	Map<String,String> answer;
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAnswer(Map<String,String> answer) {
		this.answer=answer;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public Map<String, String> getAnswer() {
		return answer;
	}
	
	public void display() {
		System.out.println("Your Question ID : "+id+"\nYour Question : "+name+"\nAnswers are : ");
		Set<Entry<String,String>> set=answer.entrySet();
		Iterator<Entry<String,String>> itr=set.iterator();
		while(itr.hasNext()) {
			Entry<String,String> entry=itr.next();
			System.out.println(entry.getKey()+"\tPosted by "+entry.getValue());
		}
	}
}
