package lamdaex;
interface Print{
	String say();
}
public class JavaLambdaExpressionEx {

	public static void main(String[] args) {
		Print p=()->{
			return "Nothing to say";
		};
		System.out.println(p.say());
	}

}
