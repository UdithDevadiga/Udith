package assignment1;

public class Employee {
	String name;
	int id;
	double salary;
	Employee(String name,int id,double salary){
		this.name=name;
		this.id=id;
		this.salary=salary;
	}
	public String toString() {
		return name;
	}

}
