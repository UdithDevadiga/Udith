package assignment2;

public class SedanCar extends Car {
	SedanCar() {
		super(CarType.SEDAN);
		construct();
	}
	protected void construct() {
		System.out.println("Sedan Car is available");
	}
//	public String toString() {
//		return "SedanCar";
//	}
	
}
