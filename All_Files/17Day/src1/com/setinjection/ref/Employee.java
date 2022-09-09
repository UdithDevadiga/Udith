package com.setinjection.ref;

public class Employee {
	
	private int id;
	private String name;
	private Address address;
	
	public void setId(int id) {
		this.id=id;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public void setAddress(Address address) {
		this.address=address;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public Address getAddress() {
		return address;
	}
	
	public void display() {
		System.out.println("Your ID : "+id+"\nYour Name : "+name+"\nYour Address : "+address.toString());
	}
}
	
