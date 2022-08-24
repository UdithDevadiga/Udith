package assignment3;

public class Faculty extends Employee {
	String designation;
	int ecNo;
	String doj;
	Faculty(String name, int age,int ecNo,String doj,String designation) {
		super(name, age);
		this.ecNo=ecNo;
		this.doj=doj;
		this.designation=designation;
	}
	void display() {
		System.out.println("Faculty Name : "+name+"\nAge : "+age+"\nEC Number : "+ecNo+"\nDate Of Joining : "+doj+"\nDesignation of Faculty  : "+designation+"\n");
	}
	
}
