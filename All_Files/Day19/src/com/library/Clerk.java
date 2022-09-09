package com.library;

import java.util.List;
import java.util.Map.Entry;

public class Clerk implements User{
	int clerkId;
	String clerkName;
	double fine;
	Clerk(int clerkId,String clerkName){
		this.clerkId=clerkId;
		this.clerkName=clerkName;
	}
	public String searchBook(String bookName) {
		if(Librarian.bookList.contains(bookName)) {
			return bookName+" is Available";
		}
		else {
			return bookName+" is Not Available";
		}
	}
	public void addBorrower(Borrower borrower) {
		Librarian.borrowerList.add(borrower);
	}
	
	public List<Borrower>getBorrowers(){
		return Librarian.borrowerList;
	}
	
	
//	public void addLoan(Borrower borrow,String bookName) {
//		loanHistory.put(borrow, bookName);
//	}
	
	public void putFine(Borrower borrow,double fine) {
		fineHistory.put(borrow, fine);
	}
	@Override
	public void getLoanHistory() {
		for(Entry<Borrower, String> m : Librarian.loanHistory.entrySet()){    
		    System.out.println(m.getKey()+" "+m.getValue());    
		   }  
		}
}

