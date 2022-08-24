package assignment3;
import java.util.Random;
import java.util.*;
public class GuessMyNumber {
	public static void main(String[] args) {
		Random ran=new Random();
		Scanner sc=new Scanner(System.in);
		int comp=ran.nextInt(11);
		while(true) {
			System.out.println("\t\t\t\tGuess The Number");
			System.out.println("Enter the number : ");
			int num=sc.nextInt();
			if(comp==num) {
				System.out.println("correct!");
				break;
			}
			else if(comp>num)
				System.out.println("Higher");
			else
				System.out.println("Lower");
		}
		sc.close();
	}
}
