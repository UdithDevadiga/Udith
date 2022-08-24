package assignment4;

class TemporaryStaff extends Person {
	String fatherName;
	String address;
	int id;
	TemporaryStaff(String name, int age,String fatherName,String address,int id) {
		super(name, age);
		this.fatherName=fatherName;
		this.address=address;
		this.id=id;
	}
	void display(String name,int id) {
		System.out.println("Name : "+name);
		System.out.println("Temporary ID : "+id);
	}

}
