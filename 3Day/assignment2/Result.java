package assignment2;

public class Result extends Test implements Sports{
	
	Result(String studentName, int rollNo, int sub1Mark, int sub2Mark, int sub3Mark) {
		super(studentName, rollNo, sub1Mark, sub2Mark, sub3Mark);
	}
	// Displays Sport Marks
	public void show_sportswt() {
		System.out.println("Sports mark is : "+sportMarks);
	}
	public static void main(String[] args) {
		Result r=new Result("Guru",102,87,85,91);
		r.show();
		r.show_marks();
		r.show_sportswt();
		int total=Sports.sportMarks+r.sub1Mark+r.sub2Mark+r.sub3Mark;
		System.out.println("Total Mark is : "+total);
	}
	
}

