package com.library;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public interface User {
	Map<Borrower,Double> fineHistory=new HashMap<Borrower,Double>();
	public String searchBook(String bookName);
	public void getLoanHistory();
}
