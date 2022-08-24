package assignment7;
import java.util.Scanner;
public class TestAge {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		Scanner c=new Scanner(System.in);
		System.out.println("Enter Name : ");
		String name=s.next();
		System.out.println("Enter Age : ");
		int age=s.nextInt();
		System.out.println("Enter RollNo : ");
		int rollNo=s.nextInt();
		System.out.println("Enter Course : ");
		String course=s.next();
		Student st=new Student(rollNo,age,name,course);
		try {
			if(st.age<15 || st.age>21) {
				throw new AgeNotWithinRangeException("Age is not within range");
			}
			else {
				System.out.println("Age is within range");
			}
		}
		catch(AgeNotWithinRangeException e) {
			System.out.println(e);
		}

}
}
