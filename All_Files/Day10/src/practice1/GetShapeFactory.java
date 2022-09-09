package practice1;

import java.util.Scanner;

public class GetShapeFactory {
	public Shape getShape(String shapeType) {
		Scanner c=new Scanner(System.in);
		if(shapeType==null) {
			return null;
		}
		if(shapeType.equalsIgnoreCase("RECTANGLE")) {
			System.out.println("Enter the length and breadth : ");
			double len=c.nextDouble();
			double breadth=c.nextDouble();
			return new Rectangle(len,breadth);
		}
		else if(shapeType.equalsIgnoreCase("Triangle")) {
			System.out.println("Enter the length and breadth and height : ");
			double len=c.nextDouble();
			double breadth=c.nextDouble();
			double height=c.nextDouble();
			return new Traingle(len,breadth,height);
		}
		return null;
	}
}
