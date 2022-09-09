package lamdaex;
import java.util.function.Function;
public class InbuiltFuctionalInterfaceEx2 {

	public static void main(String[] args) {
		Function<Integer,Integer> calci=(x)->x*x;
		System.out.println(calci.apply(4));

	}

}
