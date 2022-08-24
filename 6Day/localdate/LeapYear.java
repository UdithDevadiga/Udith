package localdate;
import java.time.LocalDate;
public class LeapYear {

	public static void main(String[] args) {
		LocalDate day1=LocalDate.of(2017, 03, 12);
		LocalDate day2=LocalDate.of(2016, 07, 17);
		System.out.println(day1.isLeapYear());
		System.out.println(day2.isLeapYear());

	}

}
