package assignment1;
import java.util.*;
public class Ques3
{
    static void compare(int a[],int b[],int l1,int l2){
    int[] c=new int[l1];
    int z=0;
    for(int i=0;i<l1;i++){
        for(int j=0;j<l2;j++){
            if(a[i]==b[j]){
                c[z]=a[i];
                z+=1;
            }
        }
    }
    System.out.println("The common elements between two arrays are : ");
    for(int k=0;k<c.length;k++){
         System.out.println(c[k]);
    }
        
    }
	public static void main(String[] args) {
	    Scanner sc=new Scanner(System.in);
	    System.out.println("Enter the size of the array 1 : ");
	    int size1=sc.nextInt();
	    System.out.println("Enter the size of the array 2 : ");
	    int size2=sc.nextInt();
	    int[] ar1=new int[size1];
    	int[] ar2=new int[size2];
    	System.out.println("Enter the array 1 elements : ");
		for(int i=0;i<size1;i++){
		    ar1[i]=sc.nextInt();
		}	
		System.out.println("Enter the array 2 elements : ");
		for(int i=0;i<size2;i++){
		    ar2[i]=sc.nextInt();
		}
		
    	compare(ar1,ar2,size1,size2);
		sc.close();
	}
}
