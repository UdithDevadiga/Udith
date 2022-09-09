package assignment1;

public class Rectangle extends Shape{
	Rectangle(double len, double breadth) {
		super(len, breadth);
	}
	double area() {
		return len*breadth;
	}
}
