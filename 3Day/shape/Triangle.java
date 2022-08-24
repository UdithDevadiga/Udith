package shape;

public class Triangle extends Rectangle {
	double height;
	Triangle(double len, double breadth,double height) {
		super(len, breadth);
		this.height=height;
	}
	// Displays Area of Triangle
	public void area() {
		double area=0.5*len*breadth*height;
		System.out.println("Area of Triangle : "+area);
	}
}
