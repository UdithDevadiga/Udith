package assignment2;

public class Sbi extends Interest{
	Sbi(String bankName, double rateOfInterest) {
		super(bankName, rateOfInterest);
	}

	String bankName() {
		return bankName;
	}
	double rateOfInterest() {
		return rateOfInterest;
	}
}
