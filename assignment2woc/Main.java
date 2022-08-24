package assignment2woc;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Country countryList[]=new Country[15];
		int r=0,flag=0; 
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
					 	countryList[r+1]=new Country(name,capital,population);
					 	break;
				case 2: System.out.println("Enter the country name : ");
						String countryName=sc.next();
						for(int i=0;i<countryList.length;i++) {
							Country temp=countryList[i];
							if(temp.countryName.equals(countryName))
								System.out.println("Country Capital : "+temp.capital+"\nCountry Population : "+temp.population);
								flag=1;
								break;
						}
						if(flag==0)
							System.out.println("Country is not found in the list");
						break;
				
				case 3: double max=countryList[0].population; 
						int z=0;
						for(int i=1;i<countryList.length;i++) {
							double temp=countryList[i].population;
							if(temp>max)
								max=temp;
								z=i;
						}
						System.out.println("Country Name With highest population is"+countryList[z].countryName);
						break;
			
				case 4:System.exit(0);
					
		}
	}
	}

}
