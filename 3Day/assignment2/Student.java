package assignment2;

public class Student {
	String studentName;
	int rollNo;
	Student(String studentName,int rollNo){
		this.studentName=studentName;
		this.rollNo=rollNo;
	}
	// Displays Student Name and Roll Number 
	void show() {
		System.out.println("Student Name : "+studentName);
		System.out.println("Student Roll Number : "+rollNo);
	}
}
