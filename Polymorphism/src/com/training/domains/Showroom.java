package com.training.domains;

import com.training.ifaces.Automobile;
import java.util.*;

/**
 * 
 * */


public class Showroom {

	public static void main(String[] args) {
		QuoteManager quote = new UpdateQuoteManager();
		Scanner sc = new Scanner(System.in);
		String choice = "n";
		do{
			System.out.println("Enter a number: " );
			int key = sc.nextInt(); 
			Automobile auto = quote.getModel(key);
			quote.printQuote(auto);
			System.out.println("n to stop, y to continue" );
			choice = sc.next();
		}while(choice.equals("y"));
		sc.close();
		
	}

}
