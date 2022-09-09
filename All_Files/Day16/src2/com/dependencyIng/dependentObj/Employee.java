package com.dependencyIng.dependentObj;

public class Employee {
	
	private String name;
	private int id;
	private Address address;
	
	Employee(){
		System.out.println("Def Employee Constructor");
	}
	
	Employee(String name,int id,Address address){
		this.name=name;
		this.id=id;
		this.address=address;
	}
	
	void display() {
		System.out.println("Your id : "+id+"\nYour Name : "+name+"\nYour address : "+address.toString());
	}
}
