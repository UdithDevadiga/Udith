package Test;

import java.util.Date;
public class Order extends OrderDetail{
	private Date date;
	private String status;
	float tax=50;
	public float calcTotal(float total,int tax) {
		return total-tax;
	}
	public void calcTotalWeight(float shippingWeight) {
		System.out.println("Total Weight is : "+shippingWeight);
	}
}
