package lamdaex;
interface SayIt{
	String say(String mes);
}
public class JavaLambdaExpEx3 {

	public static void main(String[] args) {
		SayIt s=(mes)->{
			String str="Hello! My name is ";
			return str+mes;
		};
		System.out.println(s.say("Dinesh"));
	}

}
