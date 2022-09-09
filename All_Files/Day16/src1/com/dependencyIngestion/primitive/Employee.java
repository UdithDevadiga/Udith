package com.dependencyIngestion.primitive;

public class Employee {
	private int id;
	private String name;
	
	Employee(){
		System.out.println("Def constructor");
	}
	
	Employee(int id){
		this.id=id;
	}
	
	Employee(String name){
		this.name=name;
	}
	
	Employee(int id,String name){
		this.id=id;
		this.name=name;
	}
	void show() {
		System.out.println("Your Id : "+id+"\nYour Name : "+name);
	}
	
}
