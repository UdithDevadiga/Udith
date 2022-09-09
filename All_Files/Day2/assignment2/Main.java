package assignment2;
import java.util.*;
public class Main {
	public static void main(String[] args) {
		ArrayList<Country> countryList=new ArrayList<Country>();
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println("Choices are\n1. Enter country Details\t2. Search Country Details\t3. Maximum population\t4. Exit");
			System.out.println("Enter a number : ");
			int num=sc.nextInt();
			switch(num) {
				case 1 : System.out.println("Enter the country Name : ");			
					 	String name=sc.next();
					 	System.out.println("Enter the country capital :");
					 	String capital=sc.next();
					 	System.out.println("Enter the country population");
					 	double population=sc.nextDouble();
					 	countryList.add(new Country(name,capital,population));
					 	break;
				case 2: System.out.println("Enter the country name : ");
						String countryName=sc.next();
						for(int i=0;i<countryList.size();i++) {
							Country temp=countryList.get(i);
							if(temp.countryName.equals(countryName))
								System.out.println("Country Capital : "+temp.capital+"\nCountry Population : "+temp.population);
								break;
						}
						System.out.println("Country is not found in the list");
						break;
				
				case 3: Country max=countryList.get(0);
						for(int i=1;i<countryList.size();i++) {
							Country temp=countryList.get(i);
							if(temp.population>max.population)
								max=temp;
						}
						System.out.println("Country Name With highest population is"+max.countryName);
						break;
			
				case 4:System.exit(0);
					
		}
	}
	}

}
