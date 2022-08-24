package lamdaex;
import java.util.Scanner;
import java.util.function.Predicate;
public class InbuiltFunctionalInterfaceEx {

	public static void main(String[] args) {
		Predicate<Integer> agetest=(x)->x>=18;
		Scanner c=new Scanner(System.in);
		System.out.println("Enter your age : ");
		int age=c.nextInt();
		if(agetest.test(age)) {
				System.out.println("Eligible to vote :)");
		}
		else {
			System.out.println("Nop eligible to vote :(");
		}
	}
}
