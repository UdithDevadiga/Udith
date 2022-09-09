package practice1;
public class Emp {
	int id,age,yoj;
	double salary;
	String name,gender,dept;
	Emp(String name,int id,int age,double salary,String gender,String dept,int yoj){
		this.name=name;
		this.id=id;
		this.age=age;
		this.salary=salary;
		this.gender=gender;
		this.dept=dept;
		this.yoj=yoj;
	}
	public String getName() {
		return name;
	}
	public int getId() {
		return id;
	}
	public int getAge() {
		return age;
	}
	public double getSalary() {
		return salary;
	}
	public String getGender() {
		return gender;
	}
	public String getDepartment() {
		return dept;
	}
	public int getYOJ() {
		return yoj;
	}
	public String toString() {
		return name;
	}
}
