package assignment1;
import java.util.*;
public class Ques5
{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a String : ");
		String str=sc.nextLine();
		String res=substr(str,str.length());
		System.out.println(res);
        sc.close();
	}
	public static String substr(String str,int size){
	    if(size<2){
	        return str;
	    }
	    else{
	        if(str.substring(0,2).equals(str.substring(size-2,size))){
	            
	            return str.substring(2);
	        }
	        else{
	            return str;
	        }
	    }
	}
}
