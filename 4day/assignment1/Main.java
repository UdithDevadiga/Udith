package assignment1;

public class Main {

	public static void main(String[] args) {
		Shape s=new Rectangle(10,20);
		Rectangle r=new Triangle(30,40);
		System.out.println(s.area());
		System.out.println(r.area());
	}

}
