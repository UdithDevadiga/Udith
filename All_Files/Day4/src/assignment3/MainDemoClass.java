package assignment3;

public class MainDemoClass {
	public static void main(String[] args) {
		Person p=new Person("Jeevan",35);
		Person p1=new Student("Varun",18,10,"Computer Science");
		Person p2=new Employee("Arun",20);
		Employee e1=new Staff("Manish",24,42,"14-03-2018","Technical");
		Employee e2=new Faculty("Mohan",21,58,"22-01-2021","Assoiciate Professor");
		p.display();
		p1.display();
		p2.display();
		e1.display();
		e2.display();
	}
}
