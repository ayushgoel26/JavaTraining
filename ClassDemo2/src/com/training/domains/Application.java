package com.training.domains;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Book hfirst = new Book(101, "Head First Java", "Kathy Sierra", 450);
		Book thinkJava = new Book(102, "Thinking in Java", "Bruce Erikel", 850);
		Book effJava= new Book(103, "Effective Java", "Joshua Bloch", 750);
		
//		Book[] bookList = {hfirst, thinkJava, effJava};  

		Book[] bookList = new Book[3];
		bookList[0] = hfirst;
		bookList[1] = thinkJava; 
		bookList[2] = effJava;
		
		BookManager mgr = new BookManager(); 		
		mgr.display(bookList);
		mgr.display(hfirst);
		mgr.display(hfirst,effJava, new Book(104,"abc","pqr"));
	}

}
