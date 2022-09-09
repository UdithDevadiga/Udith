package Test;

public class Customer {
	private String name;
	private String address;
	String itemName;
	int quantity;
	float price;
	Customer(String name,String address,String itemName,int quantity,float price){
		this.name=name;
		this.address=address;
		this.itemName=itemName;
		this.quantity=quantity;
		this.price=price;
	}
}
