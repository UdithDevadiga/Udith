package assignment1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter country name ");
		String countryName=s.next();
		GetCountryFactory obj=new GetCountryFactory();
		Currency c=obj.getCountry(countryName);
		System.out.println("Currency : "+c.getCurrency());
		System.out.println("Currency Symbol : "+c.getSymbol());
	}

}
