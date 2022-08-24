package assignment3;

public class Student extends Person {
	int rollNo;
	String branch;
	Student(String name, int age,int rollNo,String branch) {
		super(name, age);
		this.rollNo=rollNo;
		this.branch=branch;
	}
	void display() {
		System.out.println("Student Name : "+name+"\nAge : "+age+"\nRoll Number : "+rollNo+"\nBranch : "+branch+"\n");
	}
}
