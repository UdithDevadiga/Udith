package assignment2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		CarFactory obj=new CarFactory();
		System.out.println("Enter the CarType : ");
		Scanner s=new Scanner(System.in);
		String carType=s.next();
		if(carType==null) {
			System.out.println("Enter valid input :");
		}
		if(carType.equalsIgnoreCase("small")) {
			System.out.println(obj.buildCar(CarType.SMALL));	
	    }
		else if(carType.equalsIgnoreCase("sedan")){
			System.out.println(obj.buildCar(CarType.SEDAN));
		}
		else if(carType.equalsIgnoreCase("luxury")) {
			System.out.println(obj.buildCar(CarType.LUXURY));
		}
			 
	    }
			    
	}
