package com.library;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
public class LibraryApp {

	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		Librarian lib=context.getBean("librarian",Librarian.class);
		Clerk clerk=context.getBean("clerk",Clerk.class);
		Borrower borrow=context.getBean("borrower",Borrower.class);
		
		System.out.println(clerk.getBorrowers());
		System.out.println("1. Librarian\t2. Clerk\t3. Borrower\t4.Exit\nEnter your Role : ");
		Scanner s=new Scanner(System.in);
		Scanner c=new Scanner(System.in);
		int role=c.nextInt();
		switch(role) {
		case 1: System.out.println("Choices are 1. Search book by title\t2. View loan history of borrowers\t3. Add borrower\t4. Add new book\t5. Delete a book\t6. View Books\t7. View Books\t8.Exit\nEnter your choice : ");
				int choice1=c.nextInt();
				switch(choice1) {
					case 1: System.out.println("Enter the book you want to search : ");
							String bookName=s.next();
							System.out.println(lib.searchBook(bookName));
							break;
							
					case 2: lib.getLoanHistory();
							break;
							
					case 3: System.out.println("How many borrowers you want to add ? ");
							int bNumber=c.nextInt();
							int i=0;
							while(i<bNumber) {
								System.out.println("Enter Borrower Id : ");
								int bId=c.nextInt();
								System.out.println("Enter Borrower Name : ");
								String bName=s.next();
								lib.addBorrower(new Borrower(bId,bName));
								i++;
							}
							break;
							
					case 4: System.out.println("How many books you want to add ? ");
							int bookNumber=c.nextInt();
							int j=0;
							while(j<bookNumber) {
								System.out.println("Enter Book Name : ");
								String bookName1=s.next();
								lib.addBook(bookName1);
								j++;
							}
							break;
							
					case 5: System.out.println("How many books you want to add ? ");
							int bookNumber1=c.nextInt();
							int k=0;
							while(k<bookNumber1) {
								System.out.println("Enter Book Name : ");
								String bookName2=s.next();
								lib.deleteBook(bookName2);
								k++;
							}
							break;
							
					case 6: System.out.println(lib.getBookList());
							break;
							
					case 7: System.out.println(lib.getBookList());
							
					case 8: System.out.println("Exited");
							System.exit(0);
				}
				break;
		case 2: System.out.println("Choices are 1. Search book by title\t2. View loan history of borrowers\t3. Add borrower\t4. Add Fine\t5.Exit\nEnter your choice : ");
				int choice2=c.nextInt();
					switch(choice2) {
					case 1: System.out.println("Enter the book you want to search : ");
							String bookName=s.next();
							System.out.println(clerk.searchBook(bookName));
							break;
					
					case 2: clerk.getLoanHistory();
							break;
							
					case 3: System.out.println("How many borrowers you want to add ? ");
							int bNumber=c.nextInt();
							int i=0;
							while(i<bNumber) {
								System.out.println("Enter Borrower Id : ");
								int bId=c.nextInt();
								System.out.println("Enter Borrower Name : ");
								String bName=s.next();
								clerk.addBorrower(new Borrower(bId,bName));
								i++;
							}
							break;
							
					case 4: System.out.println("Enter Borrower ID : ");
							int id=c.nextInt();
							System.out.println("Enter Borrower Name : ");
							String name=s.next();
							System.out.println("Enter the fine : ");
							double fine=c.nextDouble();
							clerk.putFine(new Borrower(id,name),fine);
							break;
							
					case 5: System.out.println("Exited");
							System.exit(0);			
				}
				break;
		case 3: System.out.println("Choices are 1. Search book by title\t2. View loan history of borrowers\t3. Request Loan\t4. Exit\nEnter your choice : ");
				int choice3=c.nextInt();
					switch(choice3) {
						case 1: System.out.println("Enter the book you want to search : ");
								String bookName=s.next();
								System.out.println(borrow.searchBook(bookName));
								break;
								
						case 2: borrow.getLoanHistory();
								break;
							
						case 3: System.out.println("Enter Borrower ID : ");
								int id=c.nextInt();
								System.out.println("Enter Borrower Name : ");
								String name=s.next();
								System.out.println("Enter the book you want to loan");
								String bookName2=s.next();
								borrow.reqLoan(new Borrower(id,name), bookName2);
								break;
				}
				break;
		}
	}
}

