package Test;

public class Cash extends Payment{
	private float cashTendered;
	Cash(float cashTendered){
		this.cashTendered=cashTendered;
		authorize();
	}
	public void authorize() {
		System.out.println(cashTendered+" Paid Successfully :)");
	}
	
}
