package genericcla;

public class Main {

	public static void main(String[] args) {
		GenTest<Integer> obji=new GenTest<Integer>(10);
		GenTest<String> objs=new GenTest<String>("Hello");
		System.out.println(obji.display());
		System.out.println(objs.display());
	}

}
