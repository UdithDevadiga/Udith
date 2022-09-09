package assignment2;
import java.io.*;
import java.util.Scanner;
public class Count {

	public static void main(String[] args) throws IOException {
		File f1=new File("c.txt");
		Scanner ip=new Scanner(f1);
		int linecount=0;
		int charcount=0;
		int wordcount=0;
		while(ip.hasNextLine()) {
			ip.nextLine();
			linecount++;
	}
		ip=new Scanner(f1);
		while(ip.hasNext()) {
			charcount=charcount+ip.next().length();
			wordcount++;
			}
		
	System.out.println("Number of lines : "+linecount+"\nNumber of characters : "+charcount+"\nNumber of words : "+wordcount);
	ip.close();
}
}
