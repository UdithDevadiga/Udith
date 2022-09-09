package lamdaex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Product{
	int id;
	String name;
	float amt;
	Product(int id,String name,float amt){
		this.id=id;
		this.name=name;
		this.amt=amt;
	}
}
public class LambdaExpExp4 {

	public static void main(String[] args) {
		List<Product> l=new ArrayList<Product>();
		l.add(new Product(100,"Poco Phone",20000f));
		l.add(new Product(101,"Motorola",15000f));
		l.add(new Product(102,"One Plus Nord",27000f));
		System.out.println("Sorting on basis of name : ");
		Collections.sort(l,(p1,p2)->{
			return p1.name.compareTo(p2.name);
		});
		for(Product p:l) {
			System.out.println("Model Name : "+p.name+"\nModel Id : "+p.id+"\nModel Price "+p.amt);
			System.out.println();
		}
	}

}
