package assignment1;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.MonthDay;
import java.util.Scanner;

public class DateApiAssignment {

	public static void main(String[] args) {
		Scanner c=new Scanner(System.in);
		Scanner s=new Scanner(System.in);
		while(true){
			System.out.println("Choices are 1. Todays Date\t2. Current Day,Month,Year\t3. Perticular Date\t4. Compare Two Dates\t5. Recurring events");
			System.out.println("6. Check Leap Year\t7. Current Time\t8. Add Hours to Time\t9.Date before and After one Year\t10. Exit");
			System.out.println("Enter your choice : ");
			int choice=c.nextInt();
			switch(choice) {
				case 1 : System.out.println("Todays Date is : "+LocalDate.now());
						 break;
				
				case 2 : LocalDate currentDay=LocalDate.now();
						 System.out.println("Curren day : "+currentDay.getDayOfWeek());
						 System.out.println("Curren Month : "+currentDay.getMonth());
						 System.out.println("Curren Year : "+currentDay.getYear());
						 break;
						 
				case 3 : System.out.println("Enter the Day in dd format : ");
						 int day=s.nextInt();
						 System.out.println("Enter the Month in mm format : ");
						 int month=s.nextInt();
						 System.out.println("Enter the Year in yyyy format : ");
						 int year=s.nextInt();
						 LocalDate pDate=LocalDate.of(year,month,day);
						 System.out.println("Date : "+pDate);
						 break;
						 
				case 4 : System.out.println("Enter the first date in yyyy-mm-dd format : ");
						 String date1=s.next();
						 System.out.println("Enter the second date in yyyy-mm-dd format : ");
						 String date2=s.next();
						 LocalDate pdate1=LocalDate.parse(date1);
						 LocalDate pdate2=LocalDate.parse(date2);
						 if(pdate1.equals(pdate2))
							 System.out.println("Two dates are equal");
						 else
							 System.out.println("Two dates are different");
						 
				case 5 : System.out.println("Enter the first date in yyyy-mm-dd format : ");
				 		 String birth=s.next();
				 		 LocalDate pBirth=LocalDate.parse(birth);
			    		 MonthDay birthday = MonthDay.of(pBirth.getMonth(),pBirth.getDayOfMonth());
			    		 MonthDay currentMonthDay = MonthDay.from(LocalDate.now());
			    		 if (currentMonthDay.equals(birthday)) {
			    			 System.out.println("Yes!!");
			    		 } 
			    		 else {
			    			 System.out.println("Sorry, today is not your birthday");
			    		 }
						 break;
						 
				case 6 : System.out.println("Enter the Day in dd format : ");
				 		 int d=c.nextInt();
				 		 System.out.println("Enter the Month in mm format : ");
				 		 int m=c.nextInt();
				 		 System.out.println("Enter the Year in yyyy format : ");
				 		 int y=c.nextInt();
				 		 LocalDate date=LocalDate.of(y,m,d);
						 if(date.isLeapYear()==true) {
							 System.out.println("Its a Leap Year");
						 }
						 else
							 System.out.println("Its not a Leap Year");
						 break;
						 
				case 7 : System.out.println(LocalTime.now());
						 break;
						 
				case 8 : System.out.println("Enter the Time in hh-mm-ss format : ");
				 		 String time=s.next();
				 		 LocalTime ptime=LocalTime.parse(time);
						 System.out.println("Enter the hour to be added in hh format : ");
						 int hour=c.nextInt();
						 System.out.println("Time Before hours is : "+ptime);
						 System.out.println("Time After Adding hours is : "+ptime.plusHours(hour));
				 		 
				case 9 : System.out.println("Enter the date : ");
					     String str=s.next();
						 LocalDate d1=LocalDate.parse(str);
						 System.out.println("Date before one year : "+d1.minusYears(1));
						 System.out.println("Date before one year : "+d1.plusYears(1));
						 break;
						 
				case 10 : System.out.println("Exited...");
						  System.exit(0);
						 
			}
		}

	}

}
