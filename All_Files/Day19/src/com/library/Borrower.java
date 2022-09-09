package com.library;

import java.util.List;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;

public class Borrower implements User{
	private int borrowerId;
	private String borrowerName;
	@Autowired
	Borrower(int borrowerId,String borrowerName){
		this.borrowerId=borrowerId;
		this.borrowerName=borrowerName;
	}
	
	public String searchBook(String bookName) {
		if(Librarian.bookList.contains(bookName)) {
			return bookName+" is Available";
		}
		else {
			return bookName+" is Not Available";
		}
	}
	public List<String> getBookList() {
		return Librarian.bookList;
	}
	public void reqLoan(Borrower borrow,String bookName) {
		if(Librarian.bookList.contains(bookName)) {
			System.out.println("Request Accepted");
			Librarian.loanHistory.put(borrow,bookName);
		}
		else {
			System.out.println("Request Denied");
		}
	}
	
	@Override
	public String toString() {
		return "Borrower Name : "+borrowerName+"\nBorrowerID : "+borrowerId;
	}

	@Override
	public void getLoanHistory() {
		for(Entry<Borrower, String> m : Librarian.loanHistory.entrySet()){    
		    System.out.println(m.getKey()+" "+m.getValue());    
		   }  
		}
}
