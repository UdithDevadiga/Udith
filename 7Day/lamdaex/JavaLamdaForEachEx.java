package lamdaex;

import java.util.ArrayList;
import java.util.List;

public class JavaLamdaForEachEx {

	public static void main(String[] args) {
		List<String> l=new ArrayList<String>();
		l.add("Manish");
		l.add("Jeevan");
		l.add("Dhanush");
		l.add("Nishanth");
		l.forEach(
				(n)->System.out.println(n)
				);
	}

}
