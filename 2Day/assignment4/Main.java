package assignment4;

public class Main {

	public static void main(String[] args) {
		Person obj1=new Person("Rahul",32);
		TemporaryStaff obj2=new TemporaryStaff("Raghav",19,"Rajesh","Bangalore",100);
		PermanentStaff obj3=new PermanentStaff("Rajeev",25,"Dheeraj","Mangalore",55,1002);
		obj1.display();
		obj2.display();
		obj3.display();
		obj2.display("Rohan",19);
		obj3.display("Rohit",20,100);
		
	}

}
