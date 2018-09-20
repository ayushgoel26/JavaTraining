package com.training.domains;

public class Book {
	private long bookNumber;
	private String bookName;
	private String author; 
	private double ratePerUnit;
	
	// Using Default 
	// Static Variable
	static String publisher = "O' Reilly"; 
	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Book(long bookNumber, String bookName, String author) {
		this(bookNumber,bookName,author,0.0); 
	}

	public Book(long bookNumber, String bookName, String author, double ratePerUnit) {
		super();
		this.bookNumber = bookNumber;
		this.bookName = bookName;
		this.author = author;
		this.ratePerUnit = ratePerUnit;
	}
	
	public long getBookNumber() {
		return bookNumber;
	}
	
	public void setBookNumber(long bookNumber) {
		this.bookNumber = bookNumber;
	}
	
	public String getBookName() {
		return bookName;
	}
	
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public double getRatePerUnit() {
		return ratePerUnit;
	}
	
	public void setRatePerUnit(double ratePerUnit) {
		this.ratePerUnit = ratePerUnit;
	} 
	
	public double findDiscount(){
		double discount=0.10; 
		if(this.author.equals("shashi")){
			discount = 0.15; 
		}
		return discount; 
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.author + "," + this.bookName;
	}
	
	
	
}
