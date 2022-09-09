package Test;

import java.time.LocalDate;
class CreditCardExpireException extends Exception {
	CreditCardExpireException(String str){
		super(str);
	}
}
public class Credit extends Payment{
	private String name;
	private String type;
	private LocalDate expDate;
	LocalDate todaysDate=LocalDate.now();
	Credit(String name,String type,LocalDate expDate){
		this.name=name;
		this.type=type;
		this.expDate=expDate;
		authorize();
	}
	public void authorize() {
		System.out.println(type+" is a authorized type");
		System.out.println(name+" is a authorized Credit Card");
		try {
			if(expDate.equals(LocalDate.now())) {
				throw new CreditCardExpireException("Your credit card is expired .");
			}
			else {
				System.out.println(expDate+" is valid.");
			}
		}
		catch(CreditCardExpireException e) {
			System.out.println(e);
		}
	}
}
