package assignment2;

public class Test extends Student {
	int sub1Mark;
	int sub2Mark;
	int sub3Mark;
	Test(String studentName,int rollNo,int sub1Mark,int sub2Mark,int sub3Mark) {
		super(studentName,rollNo);
		this.sub1Mark=sub1Mark;
		this.sub2Mark=sub2Mark;
		this.sub3Mark=sub3Mark;
	}
	// Displays Three Subject Marks
	void show_marks() {
		System.out.println("Subject 1 Mark is : "+sub1Mark);
		System.out.println("Subject 2 Mark is : "+sub2Mark);
		System.out.println("Subject 3 Mark is : "+sub3Mark);
	}

}
