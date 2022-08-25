package assignment2;

public class LuxuryCar extends Car{
	LuxuryCar(){
		super(CarType.LUXURY);
		construct();
	}
	protected void construct() {
		System.out.println("Luxury Car is available");
	}
//	@Override
//	public String toString() {
//		return "LuxuryCar";
//	}
//	

}
