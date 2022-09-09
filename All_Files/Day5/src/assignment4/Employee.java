package assignment4;
public class Employee implements java.io.Serializable{
	String employeeName;
	int employeeId;
	double salary;
	Employee(String employeeName,int employeeId,double salary){
		this.employeeName=employeeName;
		this.employeeId=employeeId;
		this.salary=salary;
	}
}