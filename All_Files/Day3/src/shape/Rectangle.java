package shape;

class Rectangle implements shape {
	double len,breadth;
	Rectangle(double len,double breadth){
		this.len=len;
		this.breadth=breadth;
		
	}
	// Displays Area of Rectangle
	public void area() {
		System.out.println("Area Of Rectangle : "+len*breadth);
	}
}
