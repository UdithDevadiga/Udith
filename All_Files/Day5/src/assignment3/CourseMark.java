package assignment3;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
public class CourseMark {

	public static void main(String[] args) throws IOException {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the file name : ");
		String fName=sc.nextLine();
		File f1=new File(fName);
		int total=0;
		double avg=0;
		int count=0;
		Scanner ip=new Scanner(f1);
		int stu=1;
		while(ip.hasNext()) {
			String str=ip.next();
			int num=Integer.parseInt(str);
			total=total+num;
			count++;
			if(count==6) {
				System.out.println("The Total Marks of Student "+stu+" is "+total);
				avg=(double)total/6;
				System.out.println("The Average Marks of Student "+stu+" is "+avg);
				count=0;
				stu++;
				total=0;
			}
			
		}
		ip.close();
		

	}

}
