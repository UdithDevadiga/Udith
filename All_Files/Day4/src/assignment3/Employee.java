package assignment3;

public class Employee extends Person {
	Employee(String name, int age) {
		super(name, age);
	}
	void display() {
		System.out.println("Employee Name : "+name+"\nEmployee Age : "+age+"\n");
	}
}
