package assignment5;
import java.util.Scanner;
public class MarkTest {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Internal Mark : ");
		int internalMark=sc.nextInt();
		System.out.println("Enter the External Mark : ");
		int externalMark=sc.nextInt();
		try {
			if(internalMark>40) {
				throw new InternalMarkException("Internal marks is exceed");
			}
			if(externalMark>60) {
				throw new ExternalMarkException("The External Marks is exceed");
			}
		}
		catch(InternalMarkException e) {
			System.out.println(e);
		}
		catch(ExternalMarkException e) {
			System.out.println(e);
			System.out.println(e.getMessage());
		}
		
	}

}
