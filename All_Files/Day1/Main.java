package assignment1;

import java.util.Scanner;

public class Main {
	   
	 public static void main(String[] args){
	        Scanner sc=new Scanner(System.in);
	        int n=5;
	        int i=0;
	        Account myobj[]=new Account[n];
	        while(i<n)
		    {
		        System.out.println("Account Id"+ myobj[i].getId());
		        System.out.println("Account balance"+myobj[i].getBalance());
		        System.out.println("Annual Interest"+myobj[i].getAnnualInterestRate());
		        System.out.println("Date created"+myobj[i].getDateCreated());
		        System.out.println("Enter the amount to be withdrawn : ");
		        double amount1=sc.nextDouble();
		        System.out.print("Withdraw :");
		        System.out.println(myobj[i].withdraw(amount1));
		        System.out.println("Enter the amount to be withdrawn : ");
		        double amount2=sc.nextDouble();
		        System.out.println("deposit");
		        myobj[i].deposit(amount2);
		        System.out.println("Monthly Interest"+myobj[i].getMonthlyInterst());
		        System.out.println("Enter the Id : ");
		        int id=sc.nextInt();
		        System.out.println(myobj[i].setId(id));
		        System.out.println("Enter the balance : ");
		        double balance=sc.nextDouble();
		        System.out.println("Set Balance"+myobj[i].setBalance(balance));
		        System.out.println("Enter new annual Interest : ");
		        double annualInterest=sc.nextDouble();
		        myobj[i].setAnnualInterestRate(annualInterest);
		    }
	        sc.close();

	    }
	}
