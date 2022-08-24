package assignment2;

public class TestInterest {

	public static void main(String[] args) {
		Interest i1=new Sbi("SBI",4.5);
		Interest i2=new Hdfc("HDFC",4.2);
		Interest i3=new Axis("Axis",4.6);
		System.out.println("Bank Name : "+i1.bankName());
		System.out.println("Rate of Interest : "+i1.rateOfInterest());
		System.out.println("Bank Name : "+i2.bankName());
		System.out.println("Rate of Interest : "+i2.rateOfInterest());
		System.out.println("Bank Name : "+i3.bankName());
		System.out.println("Rate of Interest : "+i3.rateOfInterest());
	}
}
