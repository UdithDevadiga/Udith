package assignment4;

public class PermanentStaff extends TemporaryStaff{
	int pid;
	PermanentStaff(String name, int age, String fatherName, String address, int id,int pid) {
		super(name, age, fatherName, address, id);
		this.pid=pid;
	}
	void display(String name,int age,int pid) {
		System.out.println("Name : "+name);
		System.out.println("Age : "+age);
		System.out.println("Permanent ID : "+pid);
		
	}
}
