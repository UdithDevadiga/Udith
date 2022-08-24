package assignment;
import java.util.*;
public class Main {

	public static void main(String[] args) {
		Employee obje=new Employee("Mark",22,"9956656789","Bangalore",60000d);
		Manager objm=new Manager("Manoj",24,"9955556789","Bangalore",90000d);
//		Scanner sc=new Scanner(System.in);
		System.out.println("Employee Name :"+obje.name);
		System.out.println("Employee Age :"+obje.age);
		System.out.println("Employee Phone Number :"+obje.phoneNo);
		System.out.println("Employee Address :"+obje.address+"\nEmployee Salary : ");
		System.out.println(obje.printSalary());
		obje.printSalary();
		System.out.println();
		System.out.println("Manager Name :"+objm.name);
		System.out.println("Manager Age :"+objm.age);
		System.out.println("Manager Phone Number :"+objm.phoneNo);
		System.out.println("Manager Address :"+objm.address+"\nEmployee Salary");
		System.out.println(objm.printSalary());
		objm.printSalary();
		/***
		System.out.println("1. Employee\t2. Manager");
		System.out.println("Enter a number : ");
		int num=sc.nextInt();
		switch(num) {
			case 1 : System.out.println("Enter the number of employee : ");
					 int n=sc.nextInt();
					 for(int i=0;i<n;i++) {
						 System.out.println("Enter the name of the Employee : ");
						 String name=sc.nextLine();
						 System.out.println("Enter the age of the Employee : ");
						 int age=sc.nextInt();
						 System.out.println("Enter the phone number of the Employee : ");
						 String phoneNo=sc.nextLine();
						 System.out.println("Enter the address of the Employee : ");
						 String address=sc.nextLine();
						 System.out.println("Enter the salary of the Employee : ");
						 double salary=sc.nextDouble();
						 Employee obje[]=new Employee(name,age,phoneNo,address,salary);
						 obje[i].printSalary();
						}
					 break;
			case 2: System.out.println("Enter the number of employee : ");
			 		int n1=sc.nextInt();
			 		for(int i=0;i<n1;i++) {
			 			System.out.println("Enter the name of the Employee : ");
			 			String name=sc.nextLine();
			 			System.out.println("Enter the age of the Employee : ");
			 			int age=sc.nextInt();
			 			System.out.println("Enter the phone number of the Employee : ");
			 			String phoneNo=sc.nextLine();
			 			System.out.println("Enter the address of the Employee : ");
			 			String address=sc.nextLine();
			 			System.out.println("Enter the salary of the Employee : ");
			 			double salary=sc.nextDouble();
			 			Manager objm[]=new Manager(name,age,phoneNo,address,salary);
			 			objm[i].printSalary();
			 		}
			 		break;
		}***/
					 
	}
	

}
