package assignment2;

public class Hdfc extends Interest {

	Hdfc(String bankName, double rateOfInterest) {
		super(bankName, rateOfInterest);
	}
	String bankName() {
		return bankName;
	}
	double rateOfInterest() {
		return rateOfInterest;
	}
}
