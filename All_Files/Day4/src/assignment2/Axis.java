package assignment2;

public class Axis extends Interest {

	Axis(String bankName, double rateOfInterest) {
		super(bankName, rateOfInterest);
	}
	String bankName() {
		return bankName;
	}
	double rateOfInterest() {
		return rateOfInterest;
	}
}
