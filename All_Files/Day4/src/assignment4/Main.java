package assignment4;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter two numbers : ");
		int num1=sc.nextInt();
		int num2=sc.nextInt();
		try {
			int sum=num1+num2;
			if(sum<100) {
				System.out.println("Sum : "+sum);
			}
			else {
				throw new SumException("Sum is greater than 100");
			}
			
		}
		catch(SumException e) {
			System.out.println(e.getMessage());
		}

	}

}
