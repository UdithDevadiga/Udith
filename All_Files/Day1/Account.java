package assignment1;
import java.time.LocalDate;
public class Account {
	    int id;
	    double balance;
	    double annualInterestRate;
	    LocalDate dateCreated;
	    public Account(){
	        id=0;
	        balance=0;
	        annualInterestRate=0;
	        dateCreated=LocalDate.now();
	    }
	   
	    public  Account(int id,double balance){
	        this.id=id;
	        this.balance=balance;
	    }
	    int getId(){
	        return id;
	    }
	    double getBalance(){
	        return balance;
	    }
	    double getAnnualInterestRate(){
	        return annualInterestRate;
	    }
	    LocalDate getDateCreated(){
	        return dateCreated;
	    }
	    double getMonthlyInterstRate(){
	        double monthlyInterestRate=annualInterestRate/12;
	        return monthlyInterestRate;
	    }
	    double getMonthlyInterst(){
	        double monthlyInterest=balance*getMonthlyInterstRate();
	        return monthlyInterest;
	    }
	    int setId(int newId){
	        id=newId;
	        return id;
	    }
	    double setBalance(double balance) {
	        return balance;
	    }
	    double setAnnualInterestRate(double annualInterest){
	        return annualInterest;
	    }
	    double withdraw(double amount){
	        
	        balance=balance-amount;
	        return amount;
	        
	        
	    }
	    void deposit(double amount){
	        System.out.println("Amount deposited : "+amount);
	        balance=balance+amount;
	        System.out.println("Remaining Balance : "+balance);
	    }
	   
	}