package practice2;

public class Member {
	String name;
	int age;
	String phoneNo;
	String address;
	double salary;
	Member(String name,int age,String phoneNo,String address,double salary){
		this.name=name;
		this.age=age;
		this.phoneNo=phoneNo;
		this.address=address;
		this.salary=salary;
	}
	double printSalary() {
		return salary;
	}
}
