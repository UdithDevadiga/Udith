package assignment1;

import java.io.*;

public class Copy {

	public static void main(String[] args) throws IOException {
		FileWriter f1=new FileWriter("a.txt",true);
		FileWriter f2=new FileWriter("b.txt",true);
		FileWriter f3=new FileWriter("c.txt",true);
		f1.write("Inside Text File a");
		f2.write("Inside Text File b");
		FileReader r1=new FileReader("a.txt");
		FileReader r2=new FileReader("b.txt");
		int i;
		while((i=r1.read())!=-1) {
			f3.write(i);
		}
		while((i=r2.read())!=-1) {
			f3.write(i);
		}
		f1.close();
		f2.close();
		r1.close();
		r2.close();
		f3.close();
	}

}
