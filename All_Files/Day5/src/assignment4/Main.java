package assignment4;
import java.io.*;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException {
		while(true) {
			System.out.println(" 1 . Insert a record\t2. Display\t3. Exit");
			Scanner s=new Scanner(System.in);
			Scanner c=new Scanner(System.in);
			System.out.println("Enter a number : ");
			int num=c.nextInt();
			String fileName="emp.txt";
			switch(num) {
				case 1 : try {
								FileOutputStream emp=new FileOutputStream(fileName);
								ObjectOutputStream out=new ObjectOutputStream(emp);
								System.out.println("Enter Employee Name : ");
								String employeeName=s.next();
								System.out.println("Enter Employee ID : ");
								int employeeId=c.nextInt();
								System.out.println("Enter Salary : ");
								double salary=c.nextDouble();
								Employee obj=new Employee(employeeName,employeeId,salary);
								out.writeObject(obj);
								out.close();
								emp.close();
						 }
						 catch(IOException ex)
		         		 {
							 System.out.println("IOException is caught");
		         		 }
						 break;
				case 2 : try{
						 Employee obj1=null;
						 FileInputStream emp=new FileInputStream(fileName);
						 ObjectInputStream in=new ObjectInputStream(emp);
						 obj1=(Employee)in.readObject();
						 System.out.println("Employee Details : ");
				 		 in.close();
				 		 emp.close();
				 		 System.out.println("Employee Name : "+obj1.employeeName);
				 		 System.out.println("Employee ID : "+obj1.employeeId);
				 		 System.out.println("Employee Salary : "+obj1.salary);
						 }
						 catch(IOException ex)
		        		 {
							 System.out.println("IOException is caught");
		        		 }
				 		 catch(ClassNotFoundException ex)
		        		 {
				 			 System.out.println("ClassNotFoundException is caught");
		        		 }
				 		 break;
				 		 
				case 3: s.close();
						c.close();
						System.out.println("Exited");
						System.exit(0);
			}
		}
	}
}