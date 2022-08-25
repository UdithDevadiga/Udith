package practice1;

public class Traingle extends Shape {
	double height;
	Traingle(double len, double breadth, double height) {
		super(len, breadth);
		this.height=height;
	}
	double area() {
		return 0.5*len*breadth*height;
	}

}
