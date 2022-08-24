package assignment1;

public class Triangle extends Rectangle {
	Triangle(double len, double breadth) {
		super(len, breadth);
	}

	double area() {
		return 0.5*breadth*breadth;
}
}
