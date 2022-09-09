package assignment1;

public abstract class Shape {
	double len,breadth;
	Shape(double len,double breadth){
		this.len=len;
		this.breadth=breadth;
	}
	abstract double area();
}
