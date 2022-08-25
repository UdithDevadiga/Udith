package practice2;
public class Manager extends Member{
	Manager(String name, int age, String phoneNo, String address, double salary) {
		super(name, age, phoneNo, address, salary);
	}
	String specialization;
	String department;
}