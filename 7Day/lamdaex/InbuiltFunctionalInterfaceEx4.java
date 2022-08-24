package lamdaex;
import java.util.Date;
import java.util.function.Supplier;
public class InbuiltFunctionalInterfaceEx4 {

	public static void main(String[] args) {
		Supplier<Date> date=()->new Date();
		System.out.println("Todays Date : "+date.get());
	}

}
