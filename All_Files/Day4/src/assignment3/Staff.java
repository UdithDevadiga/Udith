package assignment3;
public class Staff extends Employee {
	int ecNo;
	String doj;
	String designation;
	Staff(String name, int age,int ecNo,String doj,String designation) {
		super(name, age);
		this.ecNo=ecNo;
		this.doj=doj;
		this.designation=designation;
	}
	void display() {
		System.out.println("Staff Name : "+name+"\nAge : "+age+"\nEC Number : "+ecNo+"\nDate Of Joining : "+doj+"\nDesignation of Staff  : "+designation+"\n");
	}
}
