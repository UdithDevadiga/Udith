package lamdaex;
@FunctionalInterface
interface Name{
	String naming(String n);
}
public class JavaLambdaExpressionEx2 {

	public static void main(String[] args) {
		Name obj=(n)->{
			return "Hello "+n;
		};
		System.out.println(obj.naming("Jeevan"));
		System.out.println(obj.naming("Dhanush"));
	}

}
