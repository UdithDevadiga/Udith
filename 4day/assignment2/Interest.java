package assignment2;

abstract class Interest {
	String bankName;
	double rateOfInterest;
	Interest(String bankName,double rateOfInterest){
		this.bankName=bankName;
		this.rateOfInterest=rateOfInterest;
	}
	abstract String bankName();
	abstract double rateOfInterest();
}
