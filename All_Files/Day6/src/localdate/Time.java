package localdate;
import java.time.LocalDate;
import java.time.LocalDateTime;
public class Time {

	public static void main(String[] args) {
		LocalDate date=LocalDate.now();
		LocalDateTime dt=date.atTime(12,34,59);
		System.out.println(dt);
	}

}
