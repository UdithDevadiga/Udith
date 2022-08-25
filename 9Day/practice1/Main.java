package practice1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		Scanner c=new Scanner(System.in);
		List<Emp> l=new ArrayList<Emp>();
		while(true) {
			System.out.println("Choices are 1. Insert Employee Deatails\t2. Employees joined after 2015\t3. Departments in the organization\t4. Employees above age 30\t5. Exit");
			int choice=c.nextInt();
			switch(choice) {
			case 1 : System.out.println("Enter Employee Name : ");
					 String name=s.next();
					 System.out.println("Enter Employee Gender : ");
					 String gender=s.next();
					 System.out.println("Enter Employee Year of joining : ");
					 int yoj=s.nextInt();
					 System.out.println("Enter Employee Department : ");
					 String dept=s.next();
					 System.out.println("Enter Employee Age : ");
					 int age=c.nextInt();
					 System.out.println("Enter Employee Salary : ");
					 double salary=c.nextDouble();
					 System.out.println("Enter Employee ID : ");
					 int id=c.nextInt();
					 l.add(new Emp(name,id,age,salary,gender,dept,yoj));
					 break;
					 
			case 2 : l.stream().filter(lst->lst.getYOJ()>2015).forEach(System.out::println);
					 break;
					 
			case 3 : l.stream().map(lst->lst.getDepartment()).distinct().forEach(System.out::println);
					 break;
				
			case 4 : l.stream().filter(lst->lst.getAge()>30).forEach(System.out::println);
					 break;
			
			case 5 : System.out.println("Exited...");
					 System.exit(0);
			}
		}
	}

}
