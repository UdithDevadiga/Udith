package lamdaex;
import java.util.Scanner;
import java.util.function.Consumer;
public class InbuiltFunctionalInterfaceEx3 {

	public static void main(String[] args) {
		System.out.println("Enter the value : ");
		Scanner c=new Scanner(System.in);
		int val=c.nextInt();
		Consumer<Integer> con=(x)->System.out.println("The value is : "+x);
		con.accept(val);
		c.close();
	}

}
