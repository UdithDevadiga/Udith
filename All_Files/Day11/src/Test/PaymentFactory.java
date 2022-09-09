package Test;

import java.time.LocalDate;
import java.util.Scanner;

public class PaymentFactory {
	public Payment getPayment(String payType) {
		Scanner s=new Scanner(System.in);
		if(payType==null) {
			return null;
		}
		if(payType.equalsIgnoreCase("cash")) {
			System.out.println("Enter cash : ");
			float cash=s.nextFloat();
			return new Cash(cash);
		}
		else if(payType.equalsIgnoreCase("check")) {
			System.out.println("Enter Bank name : ");
			String bankName=s.next();
			System.out.println("Enter Bank Id : ");
			String bankId=s.next();
			return new Check(bankName,bankId);
		}
		else if(payType.equalsIgnoreCase("credit")) {
			System.out.println("Enter Card name : ");
			String cardName=s.next();
			System.out.println("Enter Card Type : ");
			String cardType=s.next();
			System.out.println("Enter Card Expire Date in yyyy-mm-dd format : ");
			String date=s.next();
			LocalDate expDate=LocalDate.parse(date);
			return new Credit(cardName,cardType,expDate);
		}
		return null;
	}
}
