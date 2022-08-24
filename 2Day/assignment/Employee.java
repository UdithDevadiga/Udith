package assignment;

public class Employee extends Member {
	Employee(String name, int age, String phoneNo, String address, double salary) {
		super(name, age, phoneNo, address, salary);
	}
	String specialization;
	String department;
}
