package Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		List<Item> lst=new ArrayList<Item>();
		List<Customer> cusLst=new ArrayList<Customer>();
		lst.add(new Item("iphone",70000f,15,12f,"Premium SmartPhone"));
		lst.add(new Item("Vivo",40000f,15,12f,"Premium SmartPhone"));
		lst.add(new Item("Samsung",35000f,15,12f,"Premium SmartPhone"));
		lst.add(new Item("Micromax",55000f,15,12f,"Premium SmartPhone"));
		lst.add(new Item("Mi",18000f,15,12f,"Premium SmartPhone"));
		Scanner s=new Scanner(System.in);
		Scanner c=new Scanner(System.in);
		
		System.out.println("These are the available items : ");
		int lstSize=lst.size();
		for(int i=0;i<lstSize;i++) {
			System.out.println(lst.get(i).toString());
		}
		System.out.println("How many products would you like to buy : ");
		int prodNum=c.nextInt();
		int i=0;
		while(i!=prodNum) {
			System.out.println("Enter your name : ");
			String name=s.next();
			System.out.println("Enter your address : ");
			String address=s.next();
			System.out.println("Enter the item name that you want : ");
			String itemName=s.next();
			System.out.println("Enter the quanity : ");
			int quantity=c.nextInt();
			int size=lst.size();
			float price = 0;
			while(i!=size) {
				Item temp=lst.get(i);
				
				if(itemName.equalsIgnoreCase(temp.itemName))
					price=temp.price;
					break;
			}
			cusLst.add(new Customer(name,address,itemName,quantity,price));
			i++;
		}
		System.out.println("Your total will be : ");
		OrderDetail od=new OrderDetail();
		Order o=new Order();
		float total=od.calcSubTotal(cusLst);
		System.out.println(total);
		int tax=od.calcTax();
		System.out.println("Taxt applied is : "+tax);
		System.out.println("Your total after applying tax : ");
		float totAmount=o.calcTotal(total,tax);
		System.out.println(totAmount);
		System.out.println("Payment type available are : Cash, Check, Credit ");
		System.out.println("Enter the payment type : ");
		String payType=s.next();
		PaymentFactory pf=new PaymentFactory();
		pf.getPayment(payType);
		s.close();
		c.close();
		
		
	}

}
