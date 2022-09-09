package practice2;
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
	}
}
