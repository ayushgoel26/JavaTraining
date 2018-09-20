package com.training.domains;

public class BookManager {
	
	public void display(Book... books){
		displayBooks(books);	
	}
	
	private void displayBooks(Book... bookList){
		for (Book eachBook : bookList ){
			double discount = eachBook.findDiscount();
			double amount = eachBook.getRatePerUnit();
			double netAmount = amount * (1 - discount); 
			
			System.out.println(eachBook.getBookName());
			System.out.println(eachBook.getAuthor());
			System.out.println(eachBook.getRatePerUnit());
			System.out.println(eachBook.getBookNumber());
			System.out.println(discount);
			System.out.println(netAmount);
			System.out.println(Book.publisher);
			
			
			
			System.out.println(eachBook);
		}
	}
}
 