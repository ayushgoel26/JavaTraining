package com.training;
import java.util.Arrays;
import java.util.List;

import com.training.ifaces.*;

public class FirstExample {

	public static void main(String[] args) {
		IGreeting greeter = (name) -> {return "Hello " + name.toUpperCase();}; 
		System.out.println(greeter.greet("ayush"));
		
		Converter currConvert = (curr) -> {return curr*72.0;};
		System.out.println(currConvert.dollarToINR(1));
	
		String[] names = {"Ramesh","Suresh", "Magesh"};
		for(String name : names){
			System.out.println(name);
		}
		
		List<String> nameList = Arrays.asList("Ramesh","Suresh", "Magesh");
		nameList.forEach(System.out::println); 
		List<Double> intList = Arrays.asList(1.0,2.0);
		intList.forEach(System.out::println); 
		intList.forEach(currConvert::dollarToINR); 
	}

}
