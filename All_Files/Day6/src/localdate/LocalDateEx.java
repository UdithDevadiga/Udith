package localdate;

import java.time.LocalDate;
import java.time.LocalTime;

public class LocalDateEx {

	public static void main(String[] args) {
		String str="2020-04-21";
		LocalTime time=LocalTime.now();
		LocalTime timeManual=LocalTime.of(12,30,12);
		LocalDate d1=LocalDate.parse(str);
		LocalDate day=LocalDate.now();
		LocalDate yesday=day.minusDays(1);
		LocalDate tom=day.plusDays(1);
		System.out.println("Today : "+LocalDate.now());
		System.out.println("Yesterday : "+yesday);
		System.out.println("Tomorrow : "+tom);
		System.out.println("String to Date "+d1);
		System.out.println("Times Now "+time);
		System.out.println("TNow imes "+timeManual);

	}

}
