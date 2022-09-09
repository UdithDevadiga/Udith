package assignment1;
import java.util.*;
public class Ques1{
	static void reverse(int a[], int n)
	{
		int[] b = new int[n];
		int j = n;
		for (int i = 0; i < n; i++) {
			b[j - 1] = a[i];
			j = j - 1;
		}
		System.out.println("Reversed array is: \n");
		for (int k = 0; k < n; k++) {
			System.out.println(b[k]);
		}
	}

	public static void main(String[] args)
	{
	    Scanner sc=new Scanner(System.in);
	    System.out.println("Enter the size of the array : ");
	    int size=sc.nextInt();
		int [] arr =new int[size];
		System.out.println("Enter the array elements : ");
		for(int i=0;i<size;i++){
		    arr[i]=sc.nextInt();
		}
		reverse(arr, size);
		sc.close();
	}
}