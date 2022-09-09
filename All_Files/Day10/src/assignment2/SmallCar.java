package assignment2;

public class SmallCar extends Car {
	SmallCar(){
		super(CarType.SMALL);
		construct();
	}
	protected void construct() {
		System.out.println("Small Car is available");
	}
	
}
