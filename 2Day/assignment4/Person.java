package assignment4;

class Person {
	String name;
	int age;
	Person(String name,int age){
		this.name=name;
		this.age=age;
	}
	void display() {
		System.out.println("Name : "+name+"\nage : "+age);
	}

}
