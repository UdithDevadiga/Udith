package Test;

public class Check extends Payment{
	private String name;
	private String bankId;
	Check(String name,String bankId){
		this.name=name;
		this.bankId=bankId;
		authorize();
	}
	public void authorize() {
		System.out.println(bankId+" is authorized");
		System.out.println(name+" is a authorized Bank");
	}
}
