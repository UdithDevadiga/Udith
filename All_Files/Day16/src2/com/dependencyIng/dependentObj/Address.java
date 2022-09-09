package com.dependencyIng.dependentObj;

public class Address {
	
	private String city;
	private String state;
	private String country;
	
	Address(){
		System.out.println("Def Address Constructor");
	}
	
	Address(String city,String state,String country){
		this.city=city;
		this.state=state;
		this.country=country;
	}
	
	public String toString() {
		return city+", "+state+", "+country;
	}
}
