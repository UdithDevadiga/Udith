package Test;
import java.util.ArrayList;
import java.util.List;

public class Item{
	String itemName;
	float price;
	int quantity;
	@Override
	public String toString() {
		return "Item [itemName=" + itemName + ", price=" + price + ", quantity=" + quantity + ", shippingWeight="
				+ shippingWeight + ", description=" + description + "]";
	}
	private float shippingWeight;
	private String description;
	
	Item(String itemName,float price,int quantity,float shippingWeight,String description){
		this.itemName=itemName;
		this.price=price;
		this.quantity=quantity;
		this.shippingWeight=shippingWeight;
		this.description=description;
	}
	public float getPriceForQuantity(int quantity,float price) {
		float totPrice=quantity*price;
		return totPrice;
	}
	//Tax of 50 
	public float getTax() {
		float tax=50;
		return tax;
	}
	public void inStock(int quantity) {
		if(quantity==0) {
			System.out.println("Item out of Stock");
		}
		else {
			System.out.println("Item is in Stock");
		}
	}
}
