package practice3;
import java.util.Scanner;
public class Ques4
{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter two Strings : ");
		String s1=sc.nextLine();
		String s2=sc.nextLine();
		System.out.println(compare(s1.toLowerCase(),s2.toLowerCase(),s1.length(),s2.length()));
        sc.close();
	}
	static String compare(String s1,String s2,int l1,int l2){
        int flag=0;
        if(l1!=l2)
            flag=0;
        else{
            for(int i=0;i<l1;i++){
                    if(s1.charAt(i)!=s2.charAt(i))
                    {
                        flag=0;
                    }
                    else{
                        flag=1;
                        
                    }
                }
           }
        if(flag==1)
            return "Strings are same";
        else
            return "Strings are different";
    }
}
