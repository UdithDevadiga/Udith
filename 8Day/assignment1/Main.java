package assignment1;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		Scanner c=new Scanner(System.in);
		List<Employee> elist=new ArrayList<Employee>();
		while(true) {
			System.out.println("Choices are 1. Insert Employee Deatails\t2. Employee with Salary greater than 15000\t3. Employee Name Starts with 'V'\t4. Maximum Salary\t5. Total Number Employees\t6. Employee Name length greater than 4\t7. Sort based on Name\t7. Exit");
			int choice=c.nextInt();
			switch(choice) {
			case 1 : System.out.println("Enter Employee Name : ");
					 String name=s.next();
					 System.out.println("Enter Employee ID : ");
					 int id=c.nextInt();
					 System.out.println("Enter Employee Salary : ");
					 double salary=c.nextDouble();
					 elist.add(new Employee(name,id,salary));
					 break;
			
			case 2 : System.out.println("Employee with Salary Greater than 15000 : ");
					 elist.stream().filter(lst->lst.salary>15000).forEach(System.out::println);
					 break;
					 
			case 3 : System.out.println("Employee name Starting with V : ");
					 elist.stream().filter(lst->lst.name.toUpperCase().startsWith("V")).forEach(System.out::println);	
					 break;
					 
			case 4 : System.out.println("Maximum salary : ");
					 DoubleSummaryStatistics stats=elist.stream().mapToDouble(x->x.salary).summaryStatistics();
					 System.out.println(stats.getMax());
					 break;
					 
			case 5 : long count=elist.stream().count();
					 System.out.println("Total Number of employees : "+count);
					 break;
					 
			case 6 : System.out.println("Employee Having name length greater than 4 :");
				     elist.stream().filter(lst->lst.name.length()>4).forEach(System.out::println);
				     break;
				     
			case 7 : System.out.println("Employee Details.sorted based on Employee Name : ");
					 elist.stream().map(lst->lst.name).sorted().forEach(System.out::println);
					 break;
			
			case 8 : System.exit(0);
					 
			}
		}
		
	}

}
