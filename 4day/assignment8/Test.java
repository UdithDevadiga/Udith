package assignment8;
import java.util.Scanner;
public class Test {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		State s=new State();
		City c=new City();
		System.out.println("Enter State Name : ");
		String stateName=sc.next();
		s.setStateName(stateName);
		while(true) {
			System.out.println("Choices are 1. Add city\t2. Display City\t3. Exit");
			System.out.println("Enter a number : ");
			int num=sc.nextInt();
			switch(num) {
				case 1 : System.out.println("Enter the city : ");
						 String cityName=sc.next();
						 c.setCityName(cityName);
						 s.l.add(cityName);
						 break;
				case 2 :System.out.println("The cities are : ");
						System.out.println(s.getCities());
						break;
				case 3 : System.out.println("Exited");
						 System.exit(0);
			}			
		}
		
	}
}
