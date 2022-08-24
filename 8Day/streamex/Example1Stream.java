package streamex;
import java.util.*;
import java.util.stream.Collectors;

public class Example1Stream {

	public static void main(String[] args) {
		List<String> str=Arrays.asList("Jeevan","","Indra","Ashura","Mohan");
		List<String> res=str.stream().filter(string->!string.isEmpty()).collect(Collectors.toList());
		str.stream().forEach(s->System.out.println(s));
		long count=str.stream().filter(string->!string.isEmpty()).count();
		long count1=str.parallelStream().filter(string->!string.isEmpty()).count();
		System.out.println("After Removing empty string : ");
		res.stream().forEach(System.out::println);
		System.out.println("Total Non Empty String : "+count+"\t"+count1);
		Random random=new Random();
		random.ints().limit(10).forEach(System.out::println);
		System.out.println("Random number in sorted order : ");
		random.ints().limit(10).sorted().forEach(System.out::println);
	}

}
