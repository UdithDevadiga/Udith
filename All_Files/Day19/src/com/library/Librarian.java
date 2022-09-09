package com.library;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;

public class Librarian implements User{
	static List<String> bookList=new LinkedList<String>();
	static List<Borrower> borrowerList=new LinkedList<Borrower>();
	static Map<Borrower,String> loanHistory=new HashMap<Borrower,String>();
	int libId;
	String libName;
	Librarian(int libId,String libName){
		this.libId=libId;
		this.libName=libName;
	}
	
	
	public List<String> getBookList() {
		return bookList;
	}
	@Autowired
	public void setBookList(List<String> bookList) {
		Librarian.bookList = bookList;
	}

	@Autowired
	public void setBorrowerList(List<Borrower> borrowerList) {
		Librarian.borrowerList = borrowerList;
	}

	@Autowired
	public void setLoanHistory(Map<Borrower, String> loanHistory) {
		Librarian.loanHistory = loanHistory;
	}


	public String searchBook(String bookName) {
		if(bookList.contains(bookName)) {
			return bookName+" is Available";
		}
		else {
			return bookName+" is Not Available";
		}
	}
	
//	public void addLoan(Borrower borrow,String bookName) {
//		loanHistory.put(borrow, bookName);
//	}
	
	public void addBook(String bookName) {
		bookList.add(bookName);
		System.out.println("Book Added");
	}
	
	public void addBorrower(Borrower borrower) {
		borrowerList.add(borrower);
	}
	
	public void deleteBook(String bookName) {
		bookList.remove(bookName);
	}
	@Override
	public void getLoanHistory() {
		 for(Entry<Borrower, String> m : loanHistory.entrySet()){    
			    System.out.println(m.getKey().toString()+" "+m.getValue().toString());    
			   }  
		}


	@Override
	public String toString() {
		return "Librarian [loanHistory=" + loanHistory + "]";
	}
}