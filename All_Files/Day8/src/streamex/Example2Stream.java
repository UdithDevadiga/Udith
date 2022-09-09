package streamex;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Example2Stream {

	public static void main(String[] args) {
		List<Integer> num=Arrays.asList(1,2,2,3,4,5,3);
		List<Integer> res=num.stream().map(i->i*i).distinct().collect(Collectors.toList());
		res.forEach(System.out::println);
	}

}
