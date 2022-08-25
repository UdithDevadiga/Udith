package practice1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		
		GetShapeFactory shapeFactory=new GetShapeFactory();
		System.out.println("Enter the Shape : ");
		String sh=s.next();
		Shape shap=shapeFactory.getShape(sh);
		System.out.println("Area of "+sh+" is :");
		System.out.println(shap.area());
		
		
		
	}

}
