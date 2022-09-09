package com.practiceList;

import java.util.Iterator;
import java.util.List;

public class Question {
	private int id;
	private String quesName;
	List<Answers> answers;
	
	public void setId(int id) {
		this.id=id;
	}
	
	public void setQuesName(String quesName) {
		this.quesName=quesName;
	}
	
	public void setAnswers(List<Answers> answers) {
		this.answers=answers;
	}
	
	public void display() {
		System.out.println("Your Question ID : "+id+"\nYour Question : "+quesName+"\nAnswers for the above question : ");
		Iterator<Answers> itr=answers.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}

}
