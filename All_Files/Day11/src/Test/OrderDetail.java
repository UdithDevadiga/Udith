package Test;

import java.util.List;

public class OrderDetail {
	private String status;
	public float calcSubTotal(List cus) {
		int size=cus.size();
		int i=0;
		float total=0;
		while(i!=size) {
			Customer temp=(Customer)cus.get(i);
			total=total+(float)temp.price;
			i++;
		}
		status="Checked";
		System.out.println(status);
		return total;
	}
	public float calcWeight(float shippingWeight) {
		return shippingWeight;
	}
	public int calcTax() {
		int tax=50;
		return tax;
	}
	
}
