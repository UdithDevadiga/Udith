package com.dependencyIng.collection;

import java.util.Iterator;
import java.util.List;

public class Question {
	
	private int id;
	private String name;
	private List<String> answers;
	
	Question(){
		System.out.println("Def Question Constructor");
	}
	
	Question(int id,String name,List<String> answers){
		this.id=id;
		this.name=name;
		this.answers=answers;
	}
	
	public void display() {
		System.out.println("Your ID : "+id+"\nYour Ouestion : "+name);
		System.out.println("Answers are : ");
		Iterator<String> itr=answers.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}
}
