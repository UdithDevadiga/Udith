package assignment3;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		ArrayList<Employee> l=new ArrayList<Employee>();
		int flag=0;
		while(true) {
			System.out.println(" 1 . Insert a record\t2. Delete a record\t3. Display\t4. Search\t5. Update\t6. Exit");
			System.out.println("Enter a number : ");
			Scanner s=new Scanner(System.in);
			Scanner c=new Scanner(System.in);
			int num=c.nextInt();
			
			switch(num) {
				case 1 : System.out.println("Enter Employee Name : ");
						 String employeeName=s.next();
						 System.out.println("Enter Employee ID : ");
						 int employeeId=c.nextInt();
						 System.out.println("Enter Salary : ");
						 double salary=c.nextDouble();
						 l.add(new Employee(employeeName,employeeId,salary));
						 break;
				
				case 2 : System.out.println("Enter the Employee Id : ");
						 int employId=c.nextInt();
						 int size1=l.size();
						 for(int i=0;i<size1;i++) {
							 Employee temp=l.get(i);
							 if(temp.employeeId==employId) {
								 System.out.println("The Employee record having Id "+employId+" is removed");
								 l.remove(temp);
								 flag=1; 
								 break;
						 }
						 }
						 if(flag==0) {
							 System.out.println("The entered Employee Id is not present int the list");
						 }
						 break;
				case 3 : System.out.println("Employee Details : ");
						 int size2=l.size();
				 		 for(int i=0;i<size2;i++) {
				 			 Employee empDet=l.get(i);
				 			 System.out.println("Employee Name : "+empDet.employeeName+"\nEmployee ID : "+empDet.employeeId+"\nEmployee Salary : "+empDet.salary+"\n");
				 		 }
				 		 break;
				 		 
				case 4 : System.out.println("Enter the Employee ID : ");
						 int empId=c.nextInt();
						 int size3=l.size();
						 for(int i=0;i<size3;i++) {
							 Employee emp=l.get(i);
							 if(emp.employeeId==empId) {
								 System.out.println("The Employee Details : \nEmployee Name : "+emp.employeeName+"\nEmployee ID : "+emp.employeeId+"\nEmployee Salary : "+emp.salary);
								 flag=1;
								 break;
							 }
						 if(flag==0) {
							 System.out.println("Entered Employee ID is not found");
						 }
						 }
						 break;
						
				case 5 : System.out.println("Enter the Employee ID : ");
						 int empid=c.nextInt();
						 System.out.println("Enter the new Employee ID : ");
						 int newEmpid=c.nextInt();
						 System.out.println("Enter the new Employee Name : ");
						 String newEmpName=s.next();
						 System.out.println("Enter the new Employee Salary : ");
						 double newEmpSalary=c.nextDouble();
						 int size4=l.size();
						 for(int i=0;i<size4;i++) {
							 Employee emp=l.get(i);
							 if(emp.employeeId==empid) {
								 emp.employeeId=newEmpid;
								 emp.employeeName=newEmpName;
								 emp.salary=newEmpSalary;
								 System.out.println("Employee Details are Updated .");
								 flag=1;
								 break;
							 }
						 }
						 if(flag==0) {
							 System.out.println("Entered Employee ID is not found");
						 }
						 break;
				 		 
				case 6: System.exit(0);
			}
		

	}
}
}